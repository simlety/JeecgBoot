package org.jeecg.modules.demo.ldw.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.log.Log;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jeecg.modules.demo.ldw.entity.LdwProductInfo;
import org.jeecg.modules.demo.ldw.entity.RequestVO;
import org.jeecg.modules.demo.ldw.entity.ResponseProductVO;
import org.jeecg.modules.demo.ldw.mapper.LdwProductInfoMapper;
import org.jeecg.modules.demo.ldw.service.ILdwProductInfoService;
import org.jeecg.modules.demo.ldw.util.LdwUtil;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: ldw_product_info
 * @Author: jeecg-boot
 * @Date:   2025-03-16
 * @Version: V1.0
 */
@Service
public class LdwProductInfoServiceImpl extends ServiceImpl<LdwProductInfoMapper, LdwProductInfo> implements ILdwProductInfoService {

    public static final String URL = "https://erpopenplatform.irobotbox.com/api/Product/ProductInfo/GetProducts";

    @Override
    public void syncProducts(RequestVO requestVO) {
        // 是否还有更多数据
        boolean hasMoreData = true;
        int nextToken = requestVO.getNextToken();
        while (hasMoreData) {
            // 获取当前页数据
            String responseStr = LdwUtil.getResponseStr(null, null, requestVO.getStartTime(), requestVO.getEndTime(), URL,nextToken);
            ResponseProductVO responseProductVO = JSON.parseObject(responseStr, ResponseProductVO.class);
            if (responseProductVO == null || responseProductVO.getData() == null||CollUtil.isEmpty(responseProductVO.getData().getProductInfoList()) ) {
                // 没有更多数据，退出循环
                hasMoreData = false;
                Log.get().info("没有更多数据，退出循环,产品数据同步完成");
                break;
            }
            // 处理当前页数据
            List<LdwProductInfo>  productInfoList = responseProductVO.getData().getProductInfoList();
            for (LdwProductInfo ldwProductInfo : productInfoList) {
                try {
                    save(ldwProductInfo);
                    Log.get().info("nextToken："+responseProductVO.getData().getNextToken()+" ，SKU = " + ldwProductInfo.getSku() + "。产品同步成功");
                } catch (Exception e) {
                    //重复数据
                    if (StrUtil.containsAnyIgnoreCase(e.getMessage(), "duplicate")) {
                        Log.get().error("nextToken："+responseProductVO.getData().getNextToken()+" ，SKU = " + ldwProductInfo.getSku() + "。产品数据重复");
                    } else {
                        // 写异常日志表
                        try {
                            LdwUtil.addErrorRecord(ldwProductInfo.getSku(), e, "ldw_product_info");
                        } catch (Exception e2) {
                            Log.get().error("nextToken："+responseProductVO.getData().getNextToken()+" ，SKU = " + ldwProductInfo.getSku() + "。产品同步失败");
                        }
                        Log.get().error("产品数据同步失败，成功写入错误日志表，nextToken："+responseProductVO.getData().getNextToken()+" ，SKU = " + ldwProductInfo.getSku() + "。", e);
                    }
                }
            }
            // 更新页码
            nextToken = responseProductVO.getData().getNextToken();
        }
    }
}
