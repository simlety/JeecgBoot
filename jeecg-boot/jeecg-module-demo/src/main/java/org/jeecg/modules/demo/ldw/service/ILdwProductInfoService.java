package org.jeecg.modules.demo.ldw.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.demo.ldw.entity.LdwProductInfo;
import org.jeecg.modules.demo.ldw.entity.RequestVO;

/**
 * @Description: ldw_product_info
 * @Author: jeecg-boot
 * @Date:   2025-03-16
 * @Version: V1.0
 */
public interface ILdwProductInfoService extends IService<LdwProductInfo> {

    void syncProducts(RequestVO requestVO);
}
