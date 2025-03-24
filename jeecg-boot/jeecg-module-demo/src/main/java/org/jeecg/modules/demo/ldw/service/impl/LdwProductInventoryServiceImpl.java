package org.jeecg.modules.demo.ldw.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.hutool.log.Log;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jeecg.modules.demo.ldw.entity.LdwOrders;
import org.jeecg.modules.demo.ldw.entity.LdwProductInventory;
import org.jeecg.modules.demo.ldw.entity.RequestVO;
import org.jeecg.modules.demo.ldw.entity.ResponseProductInventoryVO;
import org.jeecg.modules.demo.ldw.mapper.LdwProductInventoryMapper;
import org.jeecg.modules.demo.ldw.service.ILdwOrdersService;
import org.jeecg.modules.demo.ldw.service.ILdwProductInventoryService;
import org.jeecg.modules.demo.ldw.util.LdwUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Description: ldw_product_inventory
 * @Author: jeecg-boot
 * @Date: 2025-03-24
 * @Version: V1.0
 */
@Service
public class LdwProductInventoryServiceImpl extends ServiceImpl<LdwProductInventoryMapper, LdwProductInventory> implements ILdwProductInventoryService {

    public static final String LDW_PRODUCT_INVENTORY = "ldw_product_inventory";
    @Autowired
    private ILdwOrdersService ldwOrdersService;

    @Override
    public void syncInventory(RequestVO requestVO) {


        QueryWrapper<LdwOrders> queryWrapper = new QueryWrapper<>();
        //TODO 改成配置
        queryWrapper.lambda().likeLeft(true, LdwOrders::getOrderSourceName, "LDW");
        queryWrapper.lambda().eq(true, LdwOrders::getOrderSourceName, "海外仓备库订单-LDW");
        queryWrapper.lambda().eq(true, LdwOrders::getOrderSourceName, "本地备库订单");
        queryWrapper.lambda().groupBy(LdwOrders::getWarehouseId);
        List<LdwOrders> ldwOrdersDbList = ldwOrdersService.list(queryWrapper);

        if (CollUtil.isEmpty(ldwOrdersDbList)) {
            Log.get().error("没有仓库数据，退出循环");
            return;
        }
        for (LdwOrders ldwOrders : ldwOrdersDbList) {
            Integer warehouseID = ldwOrders.getWarehouseId();
            if (warehouseID <= 0) {
                Log.get().error("仓库ID无效，跳过循环");
                continue;
            }
            // 是否还有更多数据
            boolean hasMoreData = true;
            int nextToken = 0;
            while (hasMoreData) {
                // 获取当前页数据
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
                if (mapData == null || mapData.get("data") == null || ObjectUtil.isEmpty(responseProductInventoryVO) || CollUtil.isEmpty(ldwProductInventoryList)) {
                    // 没有更多数据，退出循环
                    Log.get().info("没有更多数据，退出循环，仓库ID=" + warehouseID + ", 库存数据同步完成");
                    hasMoreData = false;
                    break;
                }

                // 处理当前页数据
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
                    Log.get().info("没有更多数据，退出循环, 库存数据同步完成");
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


    private String getResponseStr(Integer nextToken, RequestVO requestVO, Integer warehouseID) {
        // 请求URL
        String url = "https://erpopenplatform.irobotbox.com/api/Product/ProductInfo/GetProductInventory";

        // 构建JSON请求体
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
            // 发送POST请求
            String result = HttpRequest.post(url)
                    .header("User-Agent", "Apifox/1.0.0 (https://apifox.com)")
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + LdwUtil.getToken())
                    .header("Accept", "*/*")
                    .header("Host", "erpopenplatform.irobotbox.com")
                    .header("Connection", "keep-alive")
                    .body(requestBody.toString())
                    .execute()
                    .body();
            return result;
        } catch (Exception e) {
            Log.get().error("HTTP请求失败", e);
            return null;
        }
    }
}
