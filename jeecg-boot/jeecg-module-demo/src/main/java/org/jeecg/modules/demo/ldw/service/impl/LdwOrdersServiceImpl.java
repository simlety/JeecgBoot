package org.jeecg.modules.demo.ldw.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.log.Log;
import com.alibaba.fastjson.JSON;
import org.jeecg.common.api.vo.Result;
import org.jeecg.modules.demo.ldw.entity.*;
import org.jeecg.modules.demo.ldw.mapper.LdwOrdersMapper;
import org.jeecg.modules.demo.ldw.service.ILdwOrderItemsService;
import org.jeecg.modules.demo.ldw.service.ILdwOrdersService;
import org.jeecg.modules.demo.ldw.service.ILdwSyncRecordService;
import org.jeecg.modules.demo.ldw.util.LdwUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: ldw_orders
 * @Author: jeecg-boot
 * @Date: 2025-03-16
 * @Version: V1.0
 */
@Service
public class LdwOrdersServiceImpl extends ServiceImpl<LdwOrdersMapper, LdwOrders> implements ILdwOrdersService {

    public static final String URL = "https://erpopenplatform.irobotbox.com/api/Order/OrderInfo/GetOrders";

    @Autowired
    private ILdwOrderItemsService ldwOrderItemsService;

    @Override
    public void syncOrders(RequestVO requestVO) {
        int current = requestVO.getCurrent();
        boolean hasMoreData = true; // 是否还有更多数据
        while (hasMoreData) {
            // 获取当前页数据
            String responseStr = LdwUtil.getResponseStr(current, requestVO.getPageSize(), requestVO.getStartTime(), requestVO.getEndTime(), URL, null);
            ResponseOrdersVO responseOrdersVO;
            try{
                responseOrdersVO = JSON.parseObject(responseStr, ResponseOrdersVO.class);
            }catch (Exception e){
                // 写异常日志表
                try {
                    LdwUtil.addErrorRecord("requestVO:"+ JSON.toJSONString(requestVO)+" "+StrUtil.CRLF+" responseStr:"+responseStr, e, "ldw_orders");
                    Log.get().error("时间区间: "+requestVO.getStartTime()+"~"+requestVO.getEndTime()+"第" + current + "页，写入记录表失败 ,订单同步失败", e);
                } catch (Exception e2) {
                    Log.get().error("时间区间: "+requestVO.getStartTime()+"~"+requestVO.getEndTime()+"第" + current + "页，写入记录表失败 ,订单同步失败",e2);
                }
                continue;
            }


            int totalPage = responseOrdersVO.getTotalCount() / responseOrdersVO.getPageSize();
            if (responseOrdersVO == null || responseOrdersVO.getData() == null || responseOrdersVO.getData().isEmpty()) {
                // 没有更多数据，退出循环
                hasMoreData = false;
                Log.get().info("没有更多数据，退出循环,订单同步完成");
                break;
            }
            // 处理当前页数据
            List<LdwOrdersVO> ldwOrders = responseOrdersVO.getData();
            for (LdwOrdersVO ldwOrdersVO : ldwOrders) {
                LdwOrders ldwOrderEntity = Convert.convert(LdwOrders.class, ldwOrdersVO);
                List<LdwOrderItems> ldwOrderItemsList = ldwOrdersVO.getOrderList();
                try {
                    save(ldwOrderEntity);
                    //保存子订单
                    if (CollUtil.isNotEmpty(ldwOrderItemsList)) {
                        for (LdwOrderItems ldwOrderItems : ldwOrdersVO.getOrderList()) {
                            LdwOrderItems newLdwOrderItems ;
                            newLdwOrderItems = Convert.convert(LdwOrderItems.class, ldwOrderItems);
                            newLdwOrderItems.setId(null);
                            newLdwOrderItems.setOrderId(ldwOrderEntity.getId());
                            newLdwOrderItems.setOrderCode(ldwOrderEntity.getOrderCode());
                            ldwOrderItemsService.save(newLdwOrderItems);
                        }
                    }
                    Log.get().info("总共：" + (responseOrdersVO.getTotalCount() / responseOrdersVO.getPageSize()) + " 页，第" + current + "页，订单ID" + ldwOrderEntity.getOrderCode() + ",订单同步成功");
                } catch (Exception e) {
                    //重复数据
                    if (StrUtil.containsAnyIgnoreCase(e.getMessage(), "duplicate")) {
                        Log.get().error("总共：" + totalPage + " 页，第" + current + "页，订单ID" + ldwOrderEntity.getOrderCode() + ",订单重复");
                    } else {
                        // 写异常日志表
                        try {
                            LdwUtil.addErrorRecord(ldwOrderEntity.getOrderCode(), e, "ldw_orders");
                            Log.get().error("总共：" + totalPage + " 页，第" + current + "页，订单ID" + ldwOrderEntity.getOrderCode() + ",订单同步失败", e);
                        } catch (Exception e2) {
                            Log.get().error("总共：" + totalPage + " 页，第" + current + "页，写入记录表失败" + ldwOrderEntity.getOrderCode() + ",订单同步失败",e2);
                        }

                    }
                }
            }
            // 更新页码
            current++;
        }
    }


}
