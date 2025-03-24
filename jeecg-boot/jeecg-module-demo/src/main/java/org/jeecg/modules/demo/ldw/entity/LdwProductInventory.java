package org.jeecg.modules.demo.ldw.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableLogic;
import org.jeecg.common.constant.ProvinceCityArea;
import org.jeecg.common.util.SpringContextUtils;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecg.common.aspect.annotation.Dict;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: ldw_product_inventory
 * @Author: jeecg-boot
 * @Date:   2025-03-24
 * @Version: V1.0
 */
@Data
@TableName("ldw_product_inventory")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="ldw_product_inventory对象", description="ldw_product_inventory")
public class LdwProductInventory implements Serializable {
    private static final long serialVersionUID = 1L;

	/**唯一主键（自增ID）*/
	@TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "唯一主键（自增ID）")
    private java.lang.Integer id;
	/**产品SKU（平台标准识别码）*/
	@Excel(name = "产品SKU（平台标准识别码）", width = 15)
    @ApiModelProperty(value = "产品SKU（平台标准识别码）")
    private java.lang.String sku;
	/**客户自定义SKU（最大长度255）*/
	@Excel(name = "客户自定义SKU（最大长度255）", width = 15)
    @ApiModelProperty(value = "客户自定义SKU（最大长度255）")
    private java.lang.String clientSku;
	/**仓库名称（包含仓库编码信息）*/
	@Excel(name = "仓库名称（包含仓库编码信息）", width = 15)
    @ApiModelProperty(value = "仓库名称（包含仓库编码信息）")
    private java.lang.String warehouseName;
	/**可用库存数量*/
	@Excel(name = "可用库存数量", width = 15)
    @ApiModelProperty(value = "可用库存数量")
    private java.lang.Integer goodNum;
	/**锁定库存数量*/
	@Excel(name = "锁定库存数量", width = 15)
    @ApiModelProperty(value = "锁定库存数量")
    private java.lang.Integer lockNum;
	/**最后更新时间（格式：YYYY-MM-DD HH:MM:SS）*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "最后更新时间（格式：YYYY-MM-DD HH:MM:SS）")
    private java.util.Date updateTime;
	/**亚马逊标准识别号（ASIN）*/
	@Excel(name = "亚马逊标准识别号（ASIN）", width = 15)
    @ApiModelProperty(value = "亚马逊标准识别号（ASIN）")
    private java.lang.String asin;
	/**销售渠道SKU*/
	@Excel(name = "销售渠道SKU", width = 15)
    @ApiModelProperty(value = "销售渠道SKU")
    private java.lang.String sellerSku;
	/**商品活跃天数*/
	@Excel(name = "商品活跃天数", width = 15)
    @ApiModelProperty(value = "商品活跃天数")
    private java.lang.Integer activeDays;
	/**最近活跃时间*/
	@Excel(name = "最近活跃时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "最近活跃时间")
    private java.util.Date activeTime;
	/**仓库库位编码*/
	@Excel(name = "仓库库位编码", width = 15)
    @ApiModelProperty(value = "仓库库位编码")
    private java.lang.String positionCode;
	/**处理中的库存数量*/
	@Excel(name = "处理中的库存数量", width = 15)
    @ApiModelProperty(value = "处理中的库存数量")
    private java.lang.Integer processingNum;
	/**历史累计入库数量*/
	@Excel(name = "历史累计入库数量", width = 15)
    @ApiModelProperty(value = "历史累计入库数量")
    private java.lang.Integer historyInNum;
	/**历史累计出库数量*/
	@Excel(name = "历史累计出库数量", width = 15)
    @ApiModelProperty(value = "历史累计出库数量")
    private java.lang.Integer historyOutNum;
	/**最近7天出库数量*/
	@Excel(name = "最近7天出库数量", width = 15)
    @ApiModelProperty(value = "最近7天出库数量")
    private java.lang.Integer outputNum;
}
