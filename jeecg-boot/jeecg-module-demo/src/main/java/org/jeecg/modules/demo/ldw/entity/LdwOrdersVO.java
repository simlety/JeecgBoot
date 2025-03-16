package org.jeecg.modules.demo.ldw.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Description: ldw_orders
 * @Author: jeecg-boot
 * @Date:   2025-03-16
 * @Version: V1.0
 */
@Data
public class LdwOrdersVO extends LdwOrders implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<LdwOrderItems> OrderList;

}
