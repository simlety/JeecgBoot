package org.jeecg.modules.demo.ldw.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.jeecg.modules.demo.ldw.entity.LdwOrders;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description: ldw_orders
 * @Author: jeecg-boot
 * @Date: 2025-03-16
 * @Version: V1.0
 */
@Component
public interface LdwOrdersMapper extends BaseMapper<LdwOrders> {

    /**
     * 根据订单来源名称、海外仓订单和本地订单查询仓库ID列表
     *
     * @param orderSourceName 订单来源名称，用于模糊查询
     * @param overseasOrder   海外仓订单名称，用于精确匹配
     * @param localOrder      本地订单名称，用于精确匹配
     * @return 返回符合条件的 {@link LdwOrders} 列表
     */
    List<LdwOrders> selectWarehouseId(
            @Param("orderSourceName") String orderSourceName,
            @Param("overseasOrder") String overseasOrder,
            @Param("localOrder") String localOrder
    );
}
