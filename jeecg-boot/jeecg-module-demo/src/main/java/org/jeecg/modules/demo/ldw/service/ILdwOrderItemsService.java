package org.jeecg.modules.demo.ldw.service;

import org.jeecg.modules.demo.ldw.entity.LdwOrderItems;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Description: ldw_order_items
 * @Author: jeecg-boot
 * @Date:   2025-03-16
 * @Version: V1.0
 */
public interface ILdwOrderItemsService extends IService<LdwOrderItems> {

    void removeByOrderId(Integer id);
}
