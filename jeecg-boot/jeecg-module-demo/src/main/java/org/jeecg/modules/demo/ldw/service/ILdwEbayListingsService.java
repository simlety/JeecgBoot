package org.jeecg.modules.demo.ldw.service;

import org.apache.poi.ss.formula.functions.T;
import org.jeecg.modules.demo.ldw.entity.LdwEbayListings;
import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.demo.ldw.entity.RequestVO;

/**
 * @Description: ldw_ebay_listings
 * @Author: jeecg-boot
 * @Date:   2025-03-23
 * @Version: V1.0
 */
public interface ILdwEbayListingsService extends IService<LdwEbayListings> {

    void syncEbayListings(RequestVO requestVO);


}
