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
import org.jeecg.modules.demo.ldw.constant.LdwConstant;
import org.jeecg.modules.demo.ldw.entity.LdwEbayListings;
import org.jeecg.modules.demo.ldw.entity.RequestVO;
import org.jeecg.modules.demo.ldw.entity.ResponseEbayListingsVO;
import org.jeecg.modules.demo.ldw.mapper.LdwEbayListingsMapper;
import org.jeecg.modules.demo.ldw.service.ILdwEbayListingsService;
import org.jeecg.modules.demo.ldw.util.LdwUtil;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Description: ldw_ebay_listings
 * @Author: jeecg-boot
 * @Date: 2025-03-23
 * @Version: V1.0
 */
@Service
public class LdwEbayListingsServiceImpl extends ServiceImpl<LdwEbayListingsMapper, LdwEbayListings> implements ILdwEbayListingsService {

    public static final String LDW_EBAY_LISTINGS_TABLE_NAME = "ldw_ebay_listings";

    /**
     * 同步Ebay商品刊登管理数据
     *
     * @param requestVO 请求参数对象，包含分页信息、时间范围等
     */
    @Override
    public void syncEbayListings(RequestVO requestVO) {
        // 获取配置信息
        String configValue = LdwUtil.getSysConfigValueByKey(LdwConstant.LDW_ORDER_SOURCE_IDS_VALUE);
        // 检查配置是否有效
        if (StrUtil.isBlank(configValue)) {
            Log.get().error("获取订单渠道置orderSourceID数据失败，商品刊登管理数据同步终止");
            return;
        }
        List<Integer> orderSourceIDList = JSONUtil.parseArray(configValue).toList(Integer.class);
        for (Integer orderSourceID : orderSourceIDList) {
            // 是否还有更多数据
            boolean hasMoreData = true;
            int current = 0;
            while (hasMoreData) {
                // 获取当前页数据
                String responseStr = getResponseStr(current, requestVO, orderSourceID);
                List<LdwEbayListings> ldwEbayListingsList;
                Map mapData;
                ResponseEbayListingsVO responseEbayListingsVO;
                try {
                    mapData = JSON.parseObject(responseStr, Map.class);
                    String ebayObj = JSON.toJSONString(mapData.get("data"));
                    responseEbayListingsVO = JSON.parseObject(ebayObj, ResponseEbayListingsVO.class);
                    ldwEbayListingsList = responseEbayListingsVO.getEbayBasicInformationList();
                } catch (Exception e) {
                    logError(requestVO, responseStr, e);
                    continue;
                }
                if (mapData == null || mapData.get("data") == null || ObjectUtil.isEmpty(responseEbayListingsVO) || CollUtil.isEmpty(ldwEbayListingsList)) {
                    // 没有更多数据，退出循环
                    Log.get().info("没有更多数据，退出循环，渠道=" + orderSourceID + ", ebay销售数据同步完成");
                    hasMoreData = false;
                    break;
                }
                int totalPage = (responseEbayListingsVO.getRecordCount() / requestVO.getPageSize()) + 1;
                // 处理当前页数据
                for (LdwEbayListings ldwEbayListings : ldwEbayListingsList) {
                    try {
                        QueryWrapper<LdwEbayListings> queryWrapper = new QueryWrapper<>();
                        queryWrapper.lambda().eq(true, LdwEbayListings::getListingBasicId, ldwEbayListings.getListingBasicId());
                        LdwEbayListings ldwEbayListingsDb = getOne(queryWrapper);
                        if (ObjectUtil.isEmpty(ldwEbayListingsDb)) {
                            save(ldwEbayListings);
                            Log.get().info("渠道=" + orderSourceID + ",总共：" + totalPage + " 页，第" + current + "页，ListingBasicID=" + ldwEbayListings.getListingBasicId() + ",Ebay销售管理【新增】成功");
                        } else {
                            ldwEbayListings.setId(ldwEbayListingsDb.getId());
                            updateById(ldwEbayListings);
                            Log.get().info("渠道=" + orderSourceID + ",总共：" + totalPage + " 页，第" + current + "页，ListingBasicID=" + ldwEbayListings.getListingBasicId() + ",Ebay销售管理【更新】成功");
                        }
                    } catch (Exception e) {
                        handleDuplicateData(ldwEbayListings, e, totalPage, current);
                    }
                }
                // 更新页码
                current++;
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
        try {
            LdwUtil.addErrorRecord("requestVO:" + JSON.toJSONString(requestVO) + " " + StrUtil.CRLF + " responseStr:" + responseStr, e, LDW_EBAY_LISTINGS_TABLE_NAME);
            Log.get().error("时间区间: " + requestVO.getStartTime() + "~" + requestVO.getEndTime() + "第" + requestVO.getCurrent() + "页，写入记录表失败 ,订单同步失败", e);
        } catch (Exception e2) {
            Log.get().error("时间区间: " + requestVO.getStartTime() + "~" + requestVO.getEndTime() + "第" + requestVO.getCurrent() + "页，写入记录表失败 ,订单同步失败", e2);
        }
    }

    /**
     * 处理重复数据
     *
     * @param ldwEbayListings Ebay销售数据对象
     * @param e               异常对象
     * @param totalPage       总页数
     * @param current         当前页码
     */
    private void handleDuplicateData(LdwEbayListings ldwEbayListings, Exception e, int totalPage, int current) {
        if (StrUtil.containsAnyIgnoreCase(e.getMessage(), "duplicate")) {
            Log.get().error("总共：" + totalPage + " 页，第" + current + "页，ListingBasicID=" + ldwEbayListings.getListingBasicId() + ",数据重复");
        } else {
            try {
                LdwUtil.addErrorRecord(String.valueOf(ldwEbayListings.getListingBasicId()), e, LDW_EBAY_LISTINGS_TABLE_NAME);
                Log.get().error("总共：" + totalPage + " 页，第" + current + "页，ListingBasicID" + ldwEbayListings.getListingBasicId() + ",同步失败", e);
            } catch (Exception e2) {
                Log.get().error("总共：" + totalPage + " 页，第" + current + "页，ListingBasicID" + ldwEbayListings.getListingBasicId() + ",同步失败", e2);
            }
        }
    }

    /**
     * 获取HTTP请求的响应字符串
     *
     * @param requestVO     请求参数对象
     * @param orderSourceID 订单来源ID
     * @return HTTP请求的响应字符串
     */
    private String getResponseStr(Integer pageIndex, RequestVO requestVO, Integer orderSourceID) {
        JSONObject requestBody = JSONUtil.createObj()
                .set("language", "")
                .set("input", JSONUtil.createObj()
                        .set("customerID", 8120)
                        .set("pageIndex", pageIndex)
                        .set("pageSize", requestVO.getPageSize())
                        .set("orderSourceID", orderSourceID)
                        .set("itemIDs", JSONUtil.createArray())
                        .set("skUs", JSONUtil.createArray())
                        .set("orderSourceSKUs", JSONUtil.createArray())
                        .set("onSelfStartTime", requestVO.getStartTime())
                        .set("onSelfEndTime", requestVO.getEndTime())
                        .set("updateStartTime", requestVO.getStartTime())
                        .set("updateEndTime", requestVO.getEndTime())
                );
        try {
            // 发送POST请求
            String result = HttpRequest.post("https://erpopenplatform.irobotbox.com/api/Listing/EbayListingBasicV2/GetEbayBasicInformationList")
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
