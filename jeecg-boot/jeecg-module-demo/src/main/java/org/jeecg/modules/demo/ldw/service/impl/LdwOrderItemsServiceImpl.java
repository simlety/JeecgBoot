package org.jeecg.modules.demo.ldw.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jeecg.modules.demo.ldw.entity.LdwOrderItems;
import org.jeecg.modules.demo.ldw.mapper.LdwOrderItemsMapper;
import org.jeecg.modules.demo.ldw.service.ILdwOrderItemsService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: ldw_order_items
 * @Author: jeecg-boot
 * @Date: 2025-03-16
 * @Version: V1.0
 */
@Service
public class LdwOrderItemsServiceImpl extends ServiceImpl<LdwOrderItemsMapper, LdwOrderItems> implements ILdwOrderItemsService {

    /**
     * 根据订单ID删除相关的订单项
     *
     * @param orderId 订单ID，用于指定要删除的订单项所属的订单
     */
    @Override
    public void removeByOrderId(Integer orderId) {
        // 创建查询条件，根据订单ID筛选订单项
        QueryWrapper<LdwOrderItems> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(true, LdwOrderItems::getOrderId, orderId);

        // 获取符合条件的订单项列表
        List<LdwOrderItems> ldwOrderEntityDbs = list(queryWrapper);

        // 批量删除符合条件的订单项
        removeBatchByIds(ldwOrderEntityDbs);
    }
}
