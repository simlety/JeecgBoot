package org.jeecg.modules.demo.ldw.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.hutool.log.Log;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jeecg.modules.demo.ldw.constant.LdwConstant;
import org.jeecg.modules.demo.ldw.entity.*;
import org.jeecg.modules.demo.ldw.mapper.LdwProductInventoryMapper;
import org.jeecg.modules.demo.ldw.service.ILdwOrdersService;
import org.jeecg.modules.demo.ldw.service.ILdwProductInventoryService;
import org.jeecg.modules.demo.ldw.service.ILdwSysConfigService;
import org.jeecg.modules.demo.ldw.util.LdwUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * LdwProductInventoryServiceImpl 实现类
 * 负责处理库存数据的同步操作
 *
 * @Author: jeecg-boot
 * @Date: 2025-03-24
 * @Version: V1.0
 */
@Service
public class LdwProductInventoryServiceImpl extends ServiceImpl<LdwProductInventoryMapper, LdwProductInventory> implements ILdwProductInventoryService {

    public static final String LDW_PRODUCT_INVENTORY = "ldw_product_inventory";

    @Autowired
    private ILdwOrdersService ldwOrdersService;

    /**
     * 同步库存数据
     *
     * @param requestVO 请求参数对象，包含同步所需的时间区间等信息
     */
    @Override
    public void syncInventory(RequestVO requestVO) {
        // 获取配置信息
        String configValue = LdwUtil.getSysConfigValueByKey(LdwConstant.LDW_SOURCE_WHITE_KEY);
        // 检查配置是否有效
        if (StrUtil.isBlank(configValue)) {
            Log.get().error("获取渠道来源白名单配置数据失败，同步终止");
            return;
        }
        // 解析配置信息
        Map configMap = JSON.parseObject(configValue, Map.class);
        if (MapUtil.isEmpty(configMap)) {
            Log.get().error("获取渠道来源白名单MAP为NULL，同步终止");
            return;
        }

        Log.get().info("开始同步库存数据，库存渠道白名单配置信息{}.", configValue);

        // 获取仓库数据
        List<LdwOrders> ldwOrdersDbList = ldwOrdersService.selectWarehouseId(
            String.valueOf(configMap.get("orderSourceName")),
            String.valueOf(configMap.get("overseasOrder")),
            String.valueOf(configMap.get("localOrder"))
        );

        if (CollUtil.isEmpty(ldwOrdersDbList)) {
            Log.get().error("没有仓库数据，退出循环");
            return;
        }

        // 遍历仓库数据
        for (LdwOrders ldwOrders : ldwOrdersDbList) {
            Integer warehouseID = ldwOrders.getWarehouseId();
            if (warehouseID <= 0) {
                Log.get().error("仓库ID无效，跳过循环");
                continue;
            }

            // 分页获取库存数据
            boolean hasMoreData = true;
            int nextToken = 0;
            while (hasMoreData) {
                String responseStr = getResponseStr(nextToken, requestVO, warehouseID);
                List<LdwProductInventory> ldwProductInventoryList;
                Map mapData;
                ResponseProductInventoryVO responseProductInventoryVO;

                try {
                    mapData = JSON.parseObject(responseStr, Map.class);
                    String obj = JSON.toJSONString(mapData.get("data"));
                    responseProductInventoryVO = JSON.parseObject(obj, ResponseProductInventoryVO.class);
                    ldwProductInventoryList = responseProductInventoryVO.getProductInventoryList();
                } catch (Exception e) {
                    logError(requestVO, responseStr, e);
                    continue;
                }

                // 检查是否有更多数据
                if (mapData == null || mapData.get("data") == null || ObjectUtil.isEmpty(responseProductInventoryVO) || CollUtil.isEmpty(ldwProductInventoryList)) {
                    Log.get().info("没有更多数据，退出循环，仓库ID=" + warehouseID + ", 库存数据同步完成");
                    hasMoreData = false;
                    break;
                }

                // 处理当前页的库存数据
                for (LdwProductInventory ldwProductInventory : ldwProductInventoryList) {
                    try {
                        QueryWrapper<LdwProductInventory> queryWrapperProductInventory = new QueryWrapper<>();
                        queryWrapperProductInventory.lambda().eq(true, LdwProductInventory::getSku, ldwProductInventory.getSku());
                        LdwProductInventory ldwProductInventoryDb = getOne(queryWrapperProductInventory);

                        if (ObjectUtil.isEmpty(ldwProductInventoryDb)) {
                            save(ldwProductInventory);
                            Log.get().info("nextToken=" + responseProductInventoryVO.getNextToken() + " ,仓库ID=" + warehouseID + ",SKU=" + ldwProductInventory.getSku() + "，库存数据【新增】成功");
                        } else {
                            ldwProductInventory.setId(ldwProductInventoryDb.getId());
                            updateById(ldwProductInventory);
                            Log.get().info("nextToken=" + responseProductInventoryVO.getNextToken() + " ,仓库ID=" + warehouseID + ",SKU=" + ldwProductInventory.getSku() + "，库存数据【更新】成功");
                        }
                    } catch (Exception e) {
                        LdwUtil.addErrorRecord(String.valueOf(ldwProductInventory.getId()), e, LDW_PRODUCT_INVENTORY);
                        Log.get().error("nextToken=" + responseProductInventoryVO.getNextToken() + " ,仓库ID=" + warehouseID + ",SKU=" + ldwProductInventory.getSku() + "，库存数据【更新】失败", e);
                    }
                }

                if (-1 == nextToken) {
                    Log.get().info("仓库ID=" + warehouseID + ",没有更多数据，退出循环, 库存数据同步完成");
                    hasMoreData = false;
                    break;
                }

                // 更新页码
                nextToken = responseProductInventoryVO.getNextToken();
            }
        }
    }

    /**
     * 记录错误日志
     *
     * @param requestVO   请求参数对象
     * @param responseStr 响应字符串
     * @param e           异常对象
     */
    private void logError(RequestVO requestVO, String responseStr, Exception e) {
        LdwUtil.addErrorRecord("requestVO:" + JSON.toJSONString(requestVO) + " " + StrUtil.CRLF + " responseStr:" + responseStr, e, LDW_PRODUCT_INVENTORY);
        Log.get().error("时间区间: " + requestVO.getStartTime() + "~" + requestVO.getEndTime() + "页，写入记录表失败 ,订单同步失败", e);
    }

    /**
     * 获取库存数据的响应字符串
     *
     * @param nextToken   分页令牌
     * @param requestVO   请求参数对象
     * @param warehouseID 仓库ID
     * @return 响应字符串
     */
    private String getResponseStr(Integer nextToken, RequestVO requestVO, Integer warehouseID) {
        String url = "https://erpopenplatform.irobotbox.com/api/Product/ProductInfo/GetProductInventory";

        JSONObject input = JSONUtil.createObj()
                .set("customerID", 8120)
                .set("startTime", requestVO.getStartTime())
                .set("endTime", requestVO.getEndTime())
                .set("sku", "")
                .set("clientSKU", "")
                .set("warehouseID", warehouseID)
                .set("orderSourceID", 0)
                .set("orderSourceSKU", "")
                .set("asin", "")
                .set("fnsku", "")
                .set("nextToken", nextToken);

        JSONObject requestBody = JSONUtil.createObj().set("input", input);

        try {
            return HttpRequest.post(url)
                    .header("User-Agent", "Apifox/1.0.0 (https://apifox.com)")
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + LdwUtil.getToken())
                    .header("Accept", "*/*")
                    .header("Host", "erpopenplatform.irobotbox.com")
                    .header("Connection", "keep-alive")
                    .body(requestBody.toString())
                    .execute()
                    .body();
        } catch (Exception e) {
            Log.get().error("HTTP请求失败", e);
            return null;
        }
    }
}
