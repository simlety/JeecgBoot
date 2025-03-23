package org.jeecg.modules.demo.ldw.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.log.Log;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jeecg.modules.demo.ldw.entity.*;
import org.jeecg.modules.demo.ldw.mapper.LdwOrdersMapper;
import org.jeecg.modules.demo.ldw.service.ILdwOrderItemsService;
import org.jeecg.modules.demo.ldw.service.ILdwOrdersService;
import org.jeecg.modules.demo.ldw.util.LdwUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * 同步订单数据
     *
     * @param requestVO 请求参数，包含分页信息、时间区间等
     */
    @Override
    public void syncOrders(RequestVO requestVO) {
        int current = requestVO.getCurrent();
        boolean hasMoreData = true; // 是否还有更多数据

        while (hasMoreData) {
            // 获取当前页数据
            String responseStr = LdwUtil.getResponseStr(current, requestVO.getPageSize(), requestVO.getStartTime(), requestVO.getEndTime(), URL, null);
            ResponseOrdersVO responseOrdersVO;
            try {
                responseOrdersVO = JSON.parseObject(responseStr, ResponseOrdersVO.class);
            } catch (Exception e) {
                // 写异常日志表
                logError("时间区间: " + requestVO.getStartTime() + "~" + requestVO.getEndTime() + "第" + current + "页，写入记录表失败 ,订单同步失败", e, requestVO, responseStr);
                continue;
            }

            if (responseOrdersVO == null || responseOrdersVO.getData() == null || responseOrdersVO.getData().isEmpty()) {
                // 没有更多数据，退出循环
                hasMoreData = false;
                Log.get().info("没有更多数据，退出循环,订单同步完成");
                break;
            }

            int totalPage = responseOrdersVO.getTotalCount() / responseOrdersVO.getPageSize();
            // 处理当前页数据
            List<LdwOrdersVO> ldwOrders = responseOrdersVO.getData();

            // 单线程顺序处理每个订单
            for (LdwOrdersVO ldwOrdersVO : ldwOrders) {
                processOrder(ldwOrdersVO, current, totalPage);
            }

            // 更新页码
            current++;
        }
    }

    /**
     * 处理单个订单
     *
     * @param ldwOrdersVO 订单数据
     * @param current     当前页码
     * @param totalPage   总页数
     */
    private void processOrder(LdwOrdersVO ldwOrdersVO, int current, int totalPage) {
        // 将订单数据转换为实体类
        LdwOrders ldwOrderEntity = Convert.convert(LdwOrders.class, ldwOrdersVO);
        List<LdwOrderItems> ldwOrderItemsList = ldwOrdersVO.getOrderList();

        try {
            // 查询数据库中是否已存在该订单
            QueryWrapper<LdwOrders> queryWrapper = new QueryWrapper<>();
            queryWrapper.lambda().eq(true, LdwOrders::getOrderCode, ldwOrderEntity.getOrderCode());
            LdwOrders ldwOrderEntityDb = getOne(queryWrapper);

            if (ObjectUtil.isEmpty(ldwOrderEntityDb)) {
                // 如果订单不存在，则保存新订单
                save(ldwOrderEntity);
            } else {
                // 如果订单已存在，则更新订单信息
                ldwOrderEntity.setId(ldwOrderEntityDb.getId());
                updateById(ldwOrderEntity);
                // 删除旧的子订单
                ldwOrderItemsService.removeByOrderId(ldwOrderEntity.getId());
            }

            // 保存子订单
            if (CollUtil.isNotEmpty(ldwOrderItemsList)) {
                for (LdwOrderItems ldwOrderItems : ldwOrderItemsList) {
                    LdwOrderItems newLdwOrderItems = Convert.convert(LdwOrderItems.class, ldwOrderItems);
                    newLdwOrderItems.setId(null);
                    newLdwOrderItems.setOrderId(ldwOrderEntity.getId());
                    newLdwOrderItems.setOrderCode(ldwOrderEntity.getOrderCode());
                    ldwOrderItemsService.save(newLdwOrderItems);
                }
            }
            Log.get().info("总共：" + totalPage + " 页，第" + current + "页，订单ID" + ldwOrderEntity.getOrderCode() + ",订单同步成功");
        } catch (Exception e) {
            // 处理重复数据
            if (StrUtil.containsAnyIgnoreCase(e.getMessage(), "duplicate")) {
                Log.get().error("总共：" + totalPage + " 页，第" + current + "页，订单ID" + ldwOrderEntity.getOrderCode() + ",订单重复");
            } else {
                logError("总共：" + totalPage + " 页，第" + current + "页，订单ID" + ldwOrderEntity.getOrderCode() + ",订单同步失败", e, ldwOrderEntity.getOrderCode());
            }
        }
    }

    /**
     * 记录错误日志
     *
     * @param message 日志信息
     * @param e       异常对象
     * @param params  额外参数
     */
    private void logError(String message, Exception e, Object... params) {
        try {
            LdwUtil.addErrorRecord(params.length > 1 ? "requestVO:" + JSON.toJSONString(params[0]) + " " + StrUtil.CRLF + " responseStr:" + params[1] : (String) params[0], e, "ldw_orders");
            Log.get().error(message, e);
        } catch (Exception e2) {
            Log.get().error(message, e2);
        }
    }
}

