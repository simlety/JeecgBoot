package org.jeecg.modules.demo.ldw.service.impl;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;
import cn.hutool.log.Log;
import com.alibaba.fastjson.JSON;
import org.jeecg.common.util.RedisUtil;
import org.jeecg.modules.demo.ldw.entity.*;
import org.jeecg.modules.demo.ldw.mapper.LdwSyncRecordMapper;
import org.jeecg.modules.demo.ldw.service.ILdwOrderItemsService;
import org.jeecg.modules.demo.ldw.service.ILdwOrdersService;
import org.jeecg.modules.demo.ldw.service.ILdwSyncRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description: ldw_sync_record
 * @Author: jeecg-boot
 * @Date: 2025-03-16
 * @Version: V1.0
 */
@Service
public class LdwSyncRecordServiceImpl extends ServiceImpl<LdwSyncRecordMapper, LdwSyncRecord> implements ILdwSyncRecordService {
    public static final String LDW_SYNC_ORDER_CODE = "ldw_sync_order_code:";
    @Autowired
    private ILdwOrdersService ldwOrdersService;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private ILdwOrderItemsService ldwOrderItemsService;

    @Override
    public void sync(Map maps) {
        int current = 0; // 起始页码
        int pageSize = 200; // 每页大小
        boolean hasMoreData = true; // 是否还有更多数据

        while (hasMoreData) {
            // 获取当前页数据
            ResponseVO responseVO = getResponse(current, pageSize);
            if (responseVO == null || responseVO.getData() == null || responseVO.getData().isEmpty()) {
                hasMoreData = false; // 没有更多数据，退出循环
                Log.get().info("没有更多数据，退出循环,订单同步完成");
                break;
            }
            // 处理当前页数据
            String dataStr = JSON.toJSONString(responseVO.getData());
            List<LdwOrdersVO> ldwOrders = JSON.parseArray(dataStr, LdwOrdersVO.class);
            for (LdwOrdersVO ldwOrdersVO : ldwOrders) {
                LdwOrders ldwOrderEntity = Convert.convert(LdwOrders.class, ldwOrdersVO);
                if (ObjectUtil.isNotEmpty(redisUtil.get(LDW_SYNC_ORDER_CODE + ldwOrderEntity.getOrderCode()))) {
                    Log.get().info("订单ID" + ldwOrderEntity.getOrderCode() + ",订单号重复");
                    continue;
                }
                LdwOrderItems ldwOrderItemsEntity = Convert.convert(LdwOrderItems.class, ldwOrdersVO.getOrderList().get(0));
                List<LdwOrderItems> ldwOrderItemsList = ldwOrdersVO.getOrderList();
                try {
                    ldwOrdersService.save(ldwOrderEntity);
                    //保存子订单
                    for (LdwOrderItems ldwOrderItems : ldwOrdersVO.getOrderList()) {
                        ldwOrderItemsEntity.setOrderId(ldwOrderEntity.getId());
                        ldwOrderItemsEntity.setOrderCode(ldwOrderEntity.getOrderCode());
                        ldwOrderItemsService.save(ldwOrderItemsEntity);
                    }
                    redisUtil.set(LDW_SYNC_ORDER_CODE + ldwOrderEntity.getOrderCode(), ldwOrderEntity.getOrderCode(), 6000);
                    Log.get().info("第" + current + "页，订单ID" + ldwOrderEntity.getOrderCode() + ",订单同步成功");
                } catch (Exception e) {
                    log.error("订单ID" + ldwOrderEntity.getOrderCode() + ",订单同步失败", e);
                }
            }
            // 更新页码
            current++;
        }
    }


    private ResponseVO getResponse(int current, int pageSize) {
        // 构建请求头
        Map<String, String> headers = new HashMap<>();
        headers.put("User-Agent", "Apifox/1.0.0 (https://apifox.com)");
        headers.put("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjdXN0b21lcklkIjoiODEyMCIsImNsaWVudElkIjoieENPL2FHMUhlOUs4TktJVDZSSXd4dz09IiwiY2xpZW50U2VjcmV0IjoiVWhEUVArbExRQW4wamVHTk1JcEZhWWFXaVo2WExETUU4ME5RSTJVdnR1OD0iLCJuYmYiOjE3NDIxMjY0NzUsImV4cCI6MTc0NDcxODQ3NSwiaXNzIjoiRXJwQXBpSXNzdWVyIiwiYXVkIjoiRXJwQXBpQXVkaWVuY2UifQ.4fRLaAxxAXo0uY-QEqC1LS6vAN9qItoDzfdjbqPWUYE");
        headers.put("Accept", "*/*");
        headers.put("Host", "erpopenplatform.irobotbox.com");
        headers.put("Connection", "keep-alive");

        // 构建请求体
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("language", "");

        Map<String, Object> input = new HashMap<>();
        input.put("customerID", 8120);
        input.put("startTime", "2025-03-15 00:00:00");
        input.put("endTime", "2025-03-16 00:00:00");
        input.put("current", current); // 动态设置当前页码
        input.put("pageSize", pageSize); // 动态设置每页大小

        requestBody.put("input", input);

        // 发送POST请求
        String response = HttpRequest.post("https://erpopenplatform.irobotbox.com/api/Order/OrderInfo/GetOrders")
                .headerMap(headers, true)
                .contentType("application/json")
                .body(JSON.toJSONString(requestBody))
                .execute()
                .body();
        return JSON.parseObject(response, ResponseVO.class);
    }

    public static void main(String[] args) {
        // 构建请求头
        Map<String, String> headers = new HashMap<>();
        headers.put("User-Agent", "Apifox/1.0.0 (https://apifox.com)");
        headers.put("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjdXN0b21lcklkIjoiODEyMCIsImNsaWVudElkIjoieENPL2FHMUhlOUs4TktJVDZSSXd4dz09IiwiY2xpZW50U2VjcmV0IjoiVWhEUVArbExRQW4wamVHTk1JcEZhWWFXaVo2WExETUU4ME5RSTJVdnR1OD0iLCJuYmYiOjE3NDIxMjY0NzUsImV4cCI6MTc0NDcxODQ3NSwiaXNzIjoiRXJwQXBpSXNzdWVyIiwiYXVkIjoiRXJwQXBpQXVkaWVuY2UifQ.4fRLaAxxAXo0uY-QEqC1LS6vAN9qItoDzfdjbqPWUYE"); // 保持完整token
        headers.put("Accept", "*/*");
        headers.put("Host", "erpopenplatform.irobotbox.com");
        headers.put("Connection", "keep-alive");

        // 构建请求体
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("language", "");

        Map<String, Object> input = new HashMap<>();
        input.put("customerID", 8120);
        input.put("startTime", "2025-03-15 00:00:00");
        input.put("endTime", "2025-03-16 00:00:00");
        input.put("current", 11);
        input.put("pageSize", 1);

        requestBody.put("input", input);

        // 发送POST请求
        String response = HttpRequest.post("https://erpopenplatform.irobotbox.com/api/Order/OrderInfo/GetOrders")
                .headerMap(headers, true)
                .contentType("application/json")
                .body(JSON.toJSONString(requestBody))
                .execute()
                .body();
        ResponseVO responseVO = JSON.parseObject(response, ResponseVO.class);
        System.out.println(JSON.toJSONString(responseVO));
    }
}
