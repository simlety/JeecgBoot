package org.jeecg.modules.demo.ldw.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;
import cn.hutool.log.Log;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.jeecg.common.util.RedisUtil;
import org.jeecg.modules.demo.ldw.entity.*;
import org.jeecg.modules.demo.ldw.mapper.LdwSyncRecordMapper;
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
 * @Description: ldw_sync_record
 * @Author: jeecg-boot
 * @Date: 2025-03-16
 * @Version: V1.0
 */
@Service
public class LdwSyncRecordServiceImpl extends ServiceImpl<LdwSyncRecordMapper, LdwSyncRecord> implements ILdwSyncRecordService {

}
