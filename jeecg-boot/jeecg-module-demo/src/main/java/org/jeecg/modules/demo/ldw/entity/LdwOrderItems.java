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
 * @Description: ldw_order_items
 * @Author: jeecg-boot
 * @Date:   2025-03-16
 * @Version: V1.0
 */
@Data
@TableName("ldw_order_items")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="ldw_order_items对象", description="ldw_order_items")
public class LdwOrderItems implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键ID*/
	@TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "主键ID")
    private java.lang.Integer id;
	/**关联订单ID*/
	@Excel(name = "关联订单ID", width = 15)
    @ApiModelProperty(value = "关联订单ID")
    private java.lang.Integer orderId;
	/**冗余订单号（用于快速查询）*/
	@Excel(name = "冗余订单号（用于快速查询）", width = 15)
    @ApiModelProperty(value = "冗余订单号（用于快速查询）")
    private java.lang.String orderCode;
	/**系统SKU编号*/
	@Excel(name = "系统SKU编号", width = 15)
    @ApiModelProperty(value = "系统SKU编号")
    private java.lang.String sku;
	/**客户自定义SKU*/
	@Excel(name = "客户自定义SKU", width = 15)
    @ApiModelProperty(value = "客户自定义SKU")
    private java.lang.String clientSku;
	/**组合产品SKU*/
	@Excel(name = "组合产品SKU", width = 15)
    @ApiModelProperty(value = "组合产品SKU")
    private java.lang.String groupSku;
	/**组合产品客户SKU*/
	@Excel(name = "组合产品客户SKU", width = 15)
    @ApiModelProperty(value = "组合产品客户SKU")
    private java.lang.String groupClientSku;
	/**组合产品数量*/
	@Excel(name = "组合产品数量", width = 15)
    @ApiModelProperty(value = "组合产品数量")
    private java.lang.Integer groupProductNum;
	/**组合产品售价*/
	@Excel(name = "组合产品售价", width = 15)
    @ApiModelProperty(value = "组合产品售价")
    private java.math.BigDecimal groupProductPrice;
	/**产品数量*/
	@Excel(name = "产品数量", width = 15)
    @ApiModelProperty(value = "产品数量")
    private java.lang.Integer productNum;
	/**产品单价*/
	@Excel(name = "产品单价", width = 15)
    @ApiModelProperty(value = "产品单价")
    private java.math.BigDecimal productPrice;
	/**运费收入*/
	@Excel(name = "运费收入", width = 15)
    @ApiModelProperty(value = "运费收入")
    private java.math.BigDecimal shippingPrice;
	/**最新采购价（人民币）*/
	@Excel(name = "最新采购价（人民币）", width = 15)
    @ApiModelProperty(value = "最新采购价（人民币）")
    private java.math.BigDecimal lastBuyPrice;
	/**供应商报价（人民币）*/
	@Excel(name = "供应商报价（人民币）", width = 15)
    @ApiModelProperty(value = "供应商报价（人民币）")
    private java.math.BigDecimal lastSupplierPrice;
	/**头程运费（人民币）*/
	@Excel(name = "头程运费（人民币）", width = 15)
    @ApiModelProperty(value = "头程运费（人民币）")
    private java.math.BigDecimal firstLegFee;
	/**进口关税（人民币）*/
	@Excel(name = "进口关税（人民币）", width = 15)
    @ApiModelProperty(value = "进口关税（人民币）")
    private java.math.BigDecimal tariffFee;
	/**平台渠道SKU*/
	@Excel(name = "平台渠道SKU", width = 15)
    @ApiModelProperty(value = "平台渠道SKU")
    private java.lang.String sellerSku;
	/**平台商品项ID*/
	@Excel(name = "平台商品项ID", width = 15)
    @ApiModelProperty(value = "平台商品项ID")
    private java.lang.String orderItemId;
	/**亚马逊标准识别号*/
	@Excel(name = "亚马逊标准识别号", width = 15)
    @ApiModelProperty(value = "亚马逊标准识别号")
    private java.lang.String asin;
	/**商品规格参数*/
	@Excel(name = "商品规格参数", width = 15)
    @ApiModelProperty(value = "商品规格参数")
    private java.lang.String parameterValues;
	/**商品标题*/
	@Excel(name = "商品标题", width = 15)
    @ApiModelProperty(value = "商品标题")
    private java.lang.String itemTitle;
	/**是否生成包裹（0:否 1:是）*/
	@Excel(name = "是否生成包裹（0:否 1:是）", width = 15)
    @ApiModelProperty(value = "是否生成包裹（0:否 1:是）")
    private java.lang.Integer isBuildPackage;
	/**商品重量（克）*/
	@Excel(name = "商品重量（克）", width = 15)
    @ApiModelProperty(value = "商品重量（克）")
    private java.math.BigDecimal productWeight;
	/**商品长度（厘米）*/
	@Excel(name = "商品长度（厘米）", width = 15)
    @ApiModelProperty(value = "商品长度（厘米）")
    private java.math.BigDecimal productLength;
	/**商品宽度（厘米）*/
	@Excel(name = "商品宽度（厘米）", width = 15)
    @ApiModelProperty(value = "商品宽度（厘米）")
    private java.math.BigDecimal productWidth;
	/**商品高度（厘米）*/
	@Excel(name = "商品高度（厘米）", width = 15)
    @ApiModelProperty(value = "商品高度（厘米）")
    private java.math.BigDecimal productHeight;
	/**销售人员ID*/
	@Excel(name = "销售人员ID", width = 15)
    @ApiModelProperty(value = "销售人员ID")
    private java.lang.Integer businessAdminId;
	/**销售人员英文名*/
	@Excel(name = "销售人员英文名", width = 15)
    @ApiModelProperty(value = "销售人员英文名")
    private java.lang.String businessAdminNameEn;
	/**销售人员姓名*/
	@Excel(name = "销售人员姓名", width = 15)
    @ApiModelProperty(value = "销售人员姓名")
    private java.lang.String businessAdminName;
	/**开发人员ID*/
	@Excel(name = "开发人员ID", width = 15)
    @ApiModelProperty(value = "开发人员ID")
    private java.lang.Integer developAdminId;
	/**开发人员英文名*/
	@Excel(name = "开发人员英文名", width = 15)
    @ApiModelProperty(value = "开发人员英文名")
    private java.lang.String developAdminNameEn;
	/**开发人员姓名*/
	@Excel(name = "开发人员姓名", width = 15)
    @ApiModelProperty(value = "开发人员姓名")
    private java.lang.String developAdminName;
	/**商品详情页链接*/
	@Excel(name = "商品详情页链接", width = 15)
    @ApiModelProperty(value = "商品详情页链接")
    private java.lang.String productLinks;
	/**最新成本价*/
	@Excel(name = "最新成本价", width = 15)
    @ApiModelProperty(value = "最新成本价")
    private java.math.BigDecimal productLatestCost;
	/**商品净重（克）*/
	@Excel(name = "商品净重（克）", width = 15)
    @ApiModelProperty(value = "商品净重（克）")
    private java.math.BigDecimal netWeight;
	/**商品税费*/
	@Excel(name = "商品税费", width = 15)
    @ApiModelProperty(value = "商品税费")
    private java.math.BigDecimal itemTax;
}
