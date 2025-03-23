package org.jeecg.modules.demo.ldw.util;

import cn.hutool.core.exceptions.ExceptionUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.log.Log;
import com.alibaba.fastjson.JSON;
import org.jeecg.common.util.RedisUtil;
import org.jeecg.modules.demo.ldw.entity.LdwSyncRecord;
import org.jeecg.modules.demo.ldw.entity.ResponseVO;
import org.jeecg.modules.demo.ldw.service.ILdwSyncRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class LdwUtil {
    public static final String LDW_TOKEN = "ldw_token";

    private static RedisUtil redisUtil;
    private static ILdwSyncRecordService ldwSyncRecordService;

    @Autowired
    private RedisUtil redisUtilInstance;

    @Autowired
    private ILdwSyncRecordService ldwSyncRecordInstance;

    @PostConstruct
    public void init() {
        redisUtil = redisUtilInstance;
        ldwSyncRecordService = ldwSyncRecordInstance;
    }

    public static String getToken() {
        Object token = redisUtil.get(LDW_TOKEN);
        if (ObjectUtil.isNotEmpty(token)) {
            Log.get().info("缓存获取Token成功！token={}", String.valueOf(token));
            return String.valueOf(token);
        }
        // 构造请求体JSON
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("customerId", 8120);
        requestBody.put("clientId", "xCO/aG1He9K8NKIT6RIwxw==");
        requestBody.put("clientSecret", "UhDQP+lLQAn0jeGNMIpFaYaWiZ6XLDME80NQI2Uvtu8=");

        // 发送POST请求
        String result = HttpRequest.post("https://erpopenplatform.irobotbox.com/api/Authorize/Auth/GetToken")
                .header("User-Agent", "Apifox/1.0.0 (https://apifox.com)")
                .header("Content-Type", "application/json")
                .header("Accept", "*/*")
                .header("Host", "erpopenplatform.irobotbox.com")
                .header("Connection", "keep-alive")
                .body(JSON.toJSONString(requestBody))
                .execute()
                .body();
        Map resultMap = JSON.parseObject(result, Map.class);
        redisUtil.set(LDW_TOKEN, resultMap.get("token"), 60 * 60 * 6);
        Log.get().info("获取Token成功！token={}", String.valueOf(resultMap.get("token")));
        return String.valueOf(resultMap.get("token"));
    }


    public static String getResponseStr(Integer current, Integer pageSize, String startTime, String endTime, String Url,Integer nextToken) {
        // 构建请求头
        Map<String, String> headers = new HashMap<>();
        headers.put("User-Agent", "Apifox/1.0.0 (https://apifox.com)");
        headers.put("Authorization", "Bearer " + LdwUtil.getToken());
        headers.put("Accept", "*/*");
        headers.put("Host", "erpopenplatform.irobotbox.com");
        headers.put("Connection", "keep-alive");

        // 构建请求体
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("language", "");

        Map<String, Object> input = new HashMap<>();
        input.put("customerID", 8120);
        if (StrUtil.isNotEmpty(startTime)) {
            input.put("startTime", startTime);
        }
        if (StrUtil.isNotEmpty(endTime)) {
            input.put("endTime", endTime);
        }
        if (ObjectUtil.isNotEmpty(current)) {
            // 动态设置当前页码
            input.put("current", current);
        }
        if (ObjectUtil.isNotEmpty(pageSize)) {
            // 动态设置每页大小
            input.put("pageSize", pageSize);
        }
        if (ObjectUtil.isNotEmpty(nextToken)) {
            // 下一个Token，用户分批
            input.put("nextToken", nextToken);
        }
        requestBody.put("input", input);

        // 发送POST请求
        long startCostTime = System.currentTimeMillis();
        String responseStr = HttpRequest.post(Url)
                .headerMap(headers, true)
                .contentType("application/json")
                .body(JSON.toJSONString(requestBody))
                .execute()
                .body();
        Log.get().info("获取数据成功！耗时={}ms 。", System.currentTimeMillis() - startCostTime);
        return responseStr;
    }

    public static void addErrorRecord(String businessId, Exception e,String tableName){
        LdwSyncRecord ldwSyncRecord = new LdwSyncRecord();
        ldwSyncRecord.setBusinessId(businessId);
        ldwSyncRecord.setErrorMessage(ExceptionUtil.getRootCauseMessage(e));
        ldwSyncRecord.setStatus(0);
        ldwSyncRecord.setErrorStack(ExceptionUtil.stacktraceToString(e));
        ldwSyncRecord.setTableName(tableName);
        ldwSyncRecordService.save(ldwSyncRecord);
    }
}

