package org.jeecg.modules.demo.ldw.service;

import org.jeecg.modules.demo.ldw.entity.LdwProductInventory;
import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.demo.ldw.entity.RequestVO;

/**
 * @Description: ldw_product_inventory
 * @Author: jeecg-boot
 * @Date:   2025-03-24
 * @Version: V1.0
 */
public interface ILdwProductInventoryService extends IService<LdwProductInventory> {

    void syncInventory(RequestVO requestVO);
}
