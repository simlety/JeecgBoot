package org.jeecg.modules.demo.ldw.service;

import org.jeecg.modules.demo.ldw.entity.LdwOrders;
import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.demo.ldw.entity.RequestVO;

import java.util.List;

/**
 * @Description: ldw_orders
 * @Author: jeecg-boot
 * @Date:   2025-03-16
 * @Version: V1.0
 */
public interface ILdwOrdersService extends IService<LdwOrders> {
    /**
     * 根据订单来源名称、海外仓订单和本地订单查询仓库ID列表
     *
     * @param orderSourceName 订单来源名称，用于模糊查询
     * @param overseasOrder   海外仓订单名称，用于精确匹配
     * @param localOrder      本地订单名称，用于精确匹配
     * @return 返回符合条件的 {@link LdwOrders} 列表
     */
    List<LdwOrders> selectWarehouseId(String orderSourceName, String overseasOrder, String localOrder);


    /**
     * 同步订单数据
     *
     * @param requestVO 请求参数对象，包含同步订单所需的必要信息
     */
    void syncOrders(RequestVO requestVO);


}
