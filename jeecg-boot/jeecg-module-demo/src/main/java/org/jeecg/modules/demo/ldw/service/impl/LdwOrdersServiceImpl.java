package org.jeecg.modules.demo.ldw.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ArrayUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.log.Log;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jeecg.modules.demo.ldw.constant.LdwConstant;
import org.jeecg.modules.demo.ldw.entity.*;
import org.jeecg.modules.demo.ldw.mapper.LdwOrdersMapper;
import org.jeecg.modules.demo.ldw.service.ILdwOrderItemsService;
import org.jeecg.modules.demo.ldw.service.ILdwOrdersService;
import org.jeecg.modules.demo.ldw.util.LdwUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Description: ldw_orders 服务实现类
 * @Author: jeecg-boot
 * @Date: 2025-03-16
 * @Version: V1.0
 */
@Service
public class LdwOrdersServiceImpl extends ServiceImpl<LdwOrdersMapper, LdwOrders> implements ILdwOrdersService {

    public static final String URL = "https://erpopenplatform.irobotbox.com/api/Order/OrderInfo/GetOrders";

    @Autowired
    private ILdwOrderItemsService ldwOrderItemsService;
    @Autowired
    private LdwOrdersMapper ldwOrdersMapper;

    private static String[] orderSourceNameArray;

    /**
     * 根据订单来源名称、海外仓订单和本地订单查询仓库ID列表
     *
     * @param orderSourceName 订单来源名称，用于模糊查询
     * @param overseasOrder   海外仓订单名称，用于精确匹配
     * @param localOrder      本地订单名称，用于精确匹配
     * @return 返回符合条件的 {@link LdwOrders} 列表
     */
    @Override
    public List<LdwOrders> selectWarehouseId(String orderSourceName, String overseasOrder, String localOrder) {
        return ldwOrdersMapper.selectWarehouseId(orderSourceName, overseasOrder, localOrder);
    }

    /**
     * 同步订单数据
     *
     * @param requestVO 请求参数，包含分页信息、时间区间等
     */
    @Override
    public void syncOrders(RequestVO requestVO) {
        initOrderSourceNameArray();
        int current = requestVO.getCurrent();
        boolean hasMoreData = true;

        while (hasMoreData) {
            String responseStr = fetchOrderData(current, requestVO);
            if (responseStr == null) {
                hasMoreData = false;
                break;
            }

            ResponseOrdersVO responseOrdersVO = parseResponse(responseStr, current, requestVO);
            if (responseOrdersVO == null || responseOrdersVO.getData() == null || responseOrdersVO.getData().isEmpty()) {
                hasMoreData = false;
                Log.get().info("没有更多数据，退出循环,订单同步完成");
                break;
            }

            processOrderData(responseOrdersVO, current);
            current++;
        }
    }

    /**
     * 初始化订单来源名称数组
     */
    private void initOrderSourceNameArray() {
        orderSourceNameArray = new String[]{};
        String configValue = LdwUtil.getSysConfigValueByKey(LdwConstant.LDW_SOURCE_WHITE_KEY);
        Map configMap = JSON.parseObject(configValue, Map.class);
        if (MapUtil.isEmpty(configMap)) {
            Log.get().error("获取渠道来源白名单MAP为NULL，同步终止");
            return;
        }

        for (Object value : configMap.values()) {
            orderSourceNameArray = ArrayUtil.append(orderSourceNameArray, String.valueOf(value));
        }

        Log.get().info("开始同步库存数据，库存渠道白名单配置信息{}.", configValue);
        Log.get().info("渠道白名单配置数组信息{}.", JSON.toJSONString(orderSourceNameArray));
    }

    /**
     * 获取订单数据
     *
     * @param current   当前页码
     * @param requestVO 请求参数
     * @return 返回订单数据字符串
     */
    private String fetchOrderData(int current, RequestVO requestVO) {
        return LdwUtil.getResponseStr(current, requestVO.getPageSize(), requestVO.getStartTime(), requestVO.getEndTime(), URL, null);
    }

    /**
     * 解析响应数据
     *
     * @param responseStr 响应字符串
     * @param current     当前页码
     * @param requestVO   请求参数
     * @return 返回解析后的 {@link ResponseOrdersVO} 对象
     */
    private ResponseOrdersVO parseResponse(String responseStr, int current, RequestVO requestVO) {
        try {
            return JSON.parseObject(responseStr, ResponseOrdersVO.class);
        } catch (Exception e) {
            logError("时间区间: " + requestVO.getStartTime() + "~" + requestVO.getEndTime() + "第" + current + "页，写入记录表失败 ,订单同步失败", e, requestVO, responseStr);
            return null;
        }
    }

    /**
     * 处理订单数据
     *
     * @param responseOrdersVO 响应订单数据
     * @param current          当前页码
     */
    private void processOrderData(ResponseOrdersVO responseOrdersVO, int current) {
        int totalPage = responseOrdersVO.getTotalCount() / responseOrdersVO.getPageSize();
        List<LdwOrdersVO> ldwOrders = responseOrdersVO.getData();

        for (LdwOrdersVO ldwOrdersVO : ldwOrders) {
            if (StrUtil.containsAnyIgnoreCase(ldwOrdersVO.getOrderSourceName(), orderSourceNameArray)) {
                processOrder(ldwOrdersVO, current, totalPage);
            } else {
                Log.get().info("订单渠道不在白名单中，订单渠道为{}，订单号为{}", ldwOrdersVO.getOrderSourceName(), ldwOrdersVO.getOrderCode());
            }
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
        LdwOrders ldwOrderEntity = Convert.convert(LdwOrders.class, ldwOrdersVO);
        List<LdwOrderItems> ldwOrderItemsList = ldwOrdersVO.getOrderList();

        try {
            QueryWrapper<LdwOrders> queryWrapper = new QueryWrapper<>();
            queryWrapper.lambda().eq(true, LdwOrders::getOrderCode, ldwOrderEntity.getOrderCode());
            LdwOrders ldwOrderEntityDb = getOne(queryWrapper);

            if (ObjectUtil.isEmpty(ldwOrderEntityDb)) {
                save(ldwOrderEntity);
                Log.get().info("总共：" + totalPage + " 页，第" + current + "页，订单ID" + ldwOrderEntity.getOrderCode() + ",订单【新增】成功");
            } else {
                ldwOrderEntity.setId(ldwOrderEntityDb.getId());
                updateById(ldwOrderEntity);
                ldwOrderItemsService.removeByOrderId(ldwOrderEntity.getId());
                Log.get().info("总共：" + totalPage + " 页，第" + current + "页，订单ID" + ldwOrderEntity.getOrderCode() + ",订单【更新】成功");
            }

            if (CollUtil.isNotEmpty(ldwOrderItemsList)) {
                for (LdwOrderItems ldwOrderItems : ldwOrderItemsList) {
                    LdwOrderItems newLdwOrderItems = Convert.convert(LdwOrderItems.class, ldwOrderItems);
                    newLdwOrderItems.setId(null);
                    newLdwOrderItems.setOrderId(ldwOrderEntity.getId());
                    newLdwOrderItems.setOrderCode(ldwOrderEntity.getOrderCode());
                    ldwOrderItemsService.save(newLdwOrderItems);
                }
            }

        } catch (Exception e) {
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
