package org.jeecg.modules.demo.ldw.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.log.Log;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
 * @Description: ldw_product_info 服务实现类
 * @Author: jeecg-boot
 * @Date:   2025-03-16
 * @Version: V1.0
 */
@Service
public class LdwProductInfoServiceImpl extends ServiceImpl<LdwProductInfoMapper, LdwProductInfo> implements ILdwProductInfoService {

    // 产品信息获取接口URL
    public static final String URL = "https://erpopenplatform.irobotbox.com/api/Product/ProductInfo/GetProducts";

    /**
     * 同步产品信息
     * 该方法用于从指定接口获取产品信息，并将其同步到数据库中。
     *
     * @param requestVO 请求参数对象，包含分页信息、时间范围等
     */
    @Override
    public void syncProducts(RequestVO requestVO) {
        boolean hasMoreData = true; // 是否还有更多数据
        int nextToken = requestVO.getNextToken(); // 当前分页的token

        // 循环获取产品信息，直到没有更多数据
        while (hasMoreData) {
            // 获取当前页数据
            String responseStr = LdwUtil.getResponseStr(null, null, requestVO.getStartTime(), requestVO.getEndTime(), URL, nextToken);
            ResponseProductVO responseProductVO = JSON.parseObject(responseStr, ResponseProductVO.class);

            // 如果响应为空或没有数据，则退出循环
            if (responseProductVO == null || responseProductVO.getData() == null || CollUtil.isEmpty(responseProductVO.getData().getProductInfoList())) {
                Log.get().info("没有更多数据，退出循环, 产品数据同步完成");
                hasMoreData = false;
                break;
            }

            // 处理当前页的产品数据
            List<LdwProductInfo> productInfoList = responseProductVO.getData().getProductInfoList();
            for (LdwProductInfo ldwProductInfo : productInfoList) {
                processProduct(ldwProductInfo, responseProductVO.getData().getNextToken());
            }
            if(-1==nextToken){
                Log.get().info("没有更多数据，退出循环, 产品数据同步完成");
                hasMoreData = false;
                break;
            }
            // 更新nextToken，获取下一页数据
            nextToken = responseProductVO.getData().getNextToken();
        }
    }

    /**
     * 处理单个产品信息
     *
     * @param ldwProductInfo 产品信息
     * @param nextToken      当前分页的token
     */
    private void processProduct(LdwProductInfo ldwProductInfo, int nextToken) {
        try {
            // 根据SKU查询数据库中是否已存在该产品
            QueryWrapper<LdwProductInfo> queryWrapper = new QueryWrapper<>();
            queryWrapper.lambda().eq(true, LdwProductInfo::getSku, ldwProductInfo.getSku());
            LdwProductInfo ldwProductInfoDb = getOne(queryWrapper);

            // 如果数据库中不存在该产品，则保存；否则更新
            if (ObjectUtil.isEmpty(ldwProductInfoDb)) {
                save(ldwProductInfo);
                // 记录同步成功的日志
                Log.get().info("nextToken：" + nextToken + " ，SKU = " + ldwProductInfo.getSku() + "。产品【新增】成功");
            } else {
                ldwProductInfo.setId(ldwProductInfoDb.getId());
                updateById(ldwProductInfo);
                Log.get().info("nextToken：" + nextToken + " ，SKU = " + ldwProductInfo.getSku() + "。产品【更新】成功");
            }


        } catch (Exception e) {
            // 处理重复数据的情况
            if (StrUtil.containsAnyIgnoreCase(e.getMessage(), "duplicate")) {
                Log.get().error("nextToken：" + nextToken + " ，SKU = " + ldwProductInfo.getSku() + "。产品数据重复");
            } else {
                // 其他异常情况，记录错误日志
                try {
                    LdwUtil.addErrorRecord(ldwProductInfo.getSku(), e, "ldw_product_info");
                } catch (Exception e2) {
                    Log.get().error("nextToken：" + nextToken + " ，SKU = " + ldwProductInfo.getSku() + "。产品同步失败");
                }
                Log.get().error("产品数据同步失败，成功写入错误日志表，nextToken：" + nextToken + " ，SKU = " + ldwProductInfo.getSku() + "。", e);
            }
        }
    }
}

