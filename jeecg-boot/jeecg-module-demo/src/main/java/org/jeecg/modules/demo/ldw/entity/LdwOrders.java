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
 * @Description: ldw_orders
 * @Author: jeecg-boot
 * @Date:   2025-03-16
 * @Version: V1.0
 */
@Data
@TableName("ldw_orders")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="ldw_orders对象", description="ldw_orders")
public class LdwOrders implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键ID*/
	@TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "主键ID")
    private java.lang.Integer id;
	/**系统订单号（业务唯一标识）*/
	@Excel(name = "系统订单号（业务唯一标识）", width = 15)
    @ApiModelProperty(value = "系统订单号（业务唯一标识）")
    private java.lang.String orderCode;
	/**平台订单号*/
	@Excel(name = "平台订单号", width = 15)
    @ApiModelProperty(value = "平台订单号")
    private java.lang.String clientOrderCode;
	/**Ebay订单号*/
	@Excel(name = "Ebay订单号", width = 15)
    @ApiModelProperty(value = "Ebay订单号")
    private java.lang.Integer salesRecordNumber;
	/**交易号*/
	@Excel(name = "交易号", width = 15)
    @ApiModelProperty(value = "交易号")
    private java.lang.String transactionId;
	/**客户ID*/
	@Excel(name = "客户ID", width = 15)
    @ApiModelProperty(value = "客户ID")
    private java.lang.String clientUserAccount;
	/**邮箱*/
	@Excel(name = "邮箱", width = 15)
    @ApiModelProperty(value = "邮箱")
    private java.lang.String email;
	/**电话*/
	@Excel(name = "电话", width = 15)
    @ApiModelProperty(value = "电话")
    private java.lang.String telephone;
	/**来源渠道ID*/
	@Excel(name = "来源渠道ID", width = 15)
    @ApiModelProperty(value = "来源渠道ID")
    private java.lang.Integer orderSourceId;
	/**来源渠道名称*/
	@Excel(name = "来源渠道名称", width = 15)
    @ApiModelProperty(value = "来源渠道名称")
    private java.lang.String orderSourceName;
	/**付款状态（0:未付 1:已付）*/
	@Excel(name = "付款状态（0:未付 1:已付）", width = 15)
    @ApiModelProperty(value = "付款状态（0:未付 1:已付）")
    private java.lang.Integer isPay;
	/**平台支付方式*/
	@Excel(name = "平台支付方式", width = 15)
    @ApiModelProperty(value = "平台支付方式")
    private java.lang.String paymentMethods;
	/**订单状态*/
	@Excel(name = "订单状态", width = 15)
    @ApiModelProperty(value = "订单状态")
    private java.lang.Integer orderStatus;
	/**订单发货状态*/
	@Excel(name = "订单发货状态", width = 15)
    @ApiModelProperty(value = "订单发货状态")
    private java.lang.Integer orderState;
	/**订单添加时间*/
	@Excel(name = "订单添加时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "订单添加时间")
    private java.util.Date addTime;
	/**订单支付时间*/
	@Excel(name = "订单支付时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "订单支付时间")
    private java.util.Date payTime;
	/**订单最后修改时间*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "订单最后修改时间")
    private java.util.Date updateTime;
	/**订单使用币种*/
	@Excel(name = "订单使用币种", width = 15)
    @ApiModelProperty(value = "订单使用币种")
    private java.lang.String currency;
	/**订单总金额*/
	@Excel(name = "订单总金额", width = 15)
    @ApiModelProperty(value = "订单总金额")
    private java.math.BigDecimal totalPrice;
	/**优惠金额*/
	@Excel(name = "优惠金额", width = 15)
    @ApiModelProperty(value = "优惠金额")
    private java.math.BigDecimal promotionDiscountAmount;
	/**客户支付运费*/
	@Excel(name = "客户支付运费", width = 15)
    @ApiModelProperty(value = "客户支付运费")
    private java.math.BigDecimal transportPay;
	/**收货人国家代码*/
	@Excel(name = "收货人国家代码", width = 15)
    @ApiModelProperty(value = "收货人国家代码")
    private java.lang.String country;
	/**收货人省份*/
	@Excel(name = "收货人省份", width = 15)
    @ApiModelProperty(value = "收货人省份")
    private java.lang.String province;
	/**收货人城市*/
	@Excel(name = "收货人城市", width = 15)
    @ApiModelProperty(value = "收货人城市")
    private java.lang.String city;
	/**公司名称*/
	@Excel(name = "公司名称", width = 15)
    @ApiModelProperty(value = "公司名称")
    private java.lang.String companyName;
	/**邮政编码*/
	@Excel(name = "邮政编码", width = 15)
    @ApiModelProperty(value = "邮政编码")
    private java.lang.String postCode;
	/**收货人名*/
	@Excel(name = "收货人名", width = 15)
    @ApiModelProperty(value = "收货人名")
    private java.lang.String firstName;
	/**收货人姓*/
	@Excel(name = "收货人姓", width = 15)
    @ApiModelProperty(value = "收货人姓")
    private java.lang.String lastName;
	/**完整地址*/
	@Excel(name = "完整地址", width = 15)
    @ApiModelProperty(value = "完整地址")
    private java.lang.String address;
	/**地址行1*/
	@Excel(name = "地址行1", width = 15)
    @ApiModelProperty(value = "地址行1")
    private java.lang.String address1;
	/**地址行2*/
	@Excel(name = "地址行2", width = 15)
    @ApiModelProperty(value = "地址行2")
    private java.lang.String address2;
	/**地址行3*/
	@Excel(name = "地址行3", width = 15)
    @ApiModelProperty(value = "地址行3")
    private java.lang.String address3;
	/**区县名称*/
	@Excel(name = "区县名称", width = 15)
    @ApiModelProperty(value = "区县名称")
    private java.lang.String district;
	/**柜号*/
	@Excel(name = "柜号", width = 15)
    @ApiModelProperty(value = "柜号")
    private java.lang.String cabinetNo;
	/**发货方式ID*/
	@Excel(name = "发货方式ID", width = 15)
    @ApiModelProperty(value = "发货方式ID")
    private java.lang.Integer transportId;
	/**发货方式名称*/
	@Excel(name = "发货方式名称", width = 15)
    @ApiModelProperty(value = "发货方式名称")
    private java.lang.String transportName;
	/**订单备注描述*/
	@Excel(name = "订单备注描述", width = 15)
    @ApiModelProperty(value = "订单备注描述")
    private java.lang.String orderDescription;
	/**是否FBA订单（0:否 1:是）*/
	@Excel(name = "是否FBA订单（0:否 1:是）", width = 15)
    @ApiModelProperty(value = "是否FBA订单（0:否 1:是）")
    private java.lang.Integer isFbaOrder;
	/**发货仓库ID*/
	@Excel(name = "发货仓库ID", width = 15)
    @ApiModelProperty(value = "发货仓库ID")
    private java.lang.Integer warehouseId;
	/**订单总重量（克）*/
	@Excel(name = "订单总重量（克）", width = 15)
    @ApiModelProperty(value = "订单总重量（克）")
    private java.math.BigDecimal productWeight;
	/**平台配送服务名称*/
	@Excel(name = "平台配送服务名称", width = 15)
    @ApiModelProperty(value = "平台配送服务名称")
    private java.lang.String shipService;
	/**物流追踪号码*/
	@Excel(name = "物流追踪号码", width = 15)
    @ApiModelProperty(value = "物流追踪号码")
    private java.lang.String trackNumbers;
	/**Paypal手续费*/
	@Excel(name = "Paypal手续费", width = 15)
    @ApiModelProperty(value = "Paypal手续费")
    private java.math.BigDecimal paypalFee;
	/**退款返还Paypal手续费*/
	@Excel(name = "退款返还Paypal手续费", width = 15)
    @ApiModelProperty(value = "退款返还Paypal手续费")
    private java.math.BigDecimal refundPaypalFee;
	/**Paypal交易手续费*/
	@Excel(name = "Paypal交易手续费", width = 15)
    @ApiModelProperty(value = "Paypal交易手续费")
    private java.math.BigDecimal paypalTransactionFee;
	/**支付方式名称*/
	@Excel(name = "支付方式名称", width = 15)
    @ApiModelProperty(value = "支付方式名称")
    private java.lang.String paymentTypeName;
	/**支付方式代码*/
	@Excel(name = "支付方式代码", width = 15)
    @ApiModelProperty(value = "支付方式代码")
    private java.lang.Integer paymentTypeValue;
	/**物流商单号*/
	@Excel(name = "物流商单号", width = 15)
    @ApiModelProperty(value = "物流商单号")
    private java.lang.String logisticsOrderNo;
	/**物流商转单号*/
	@Excel(name = "物流商转单号", width = 15)
    @ApiModelProperty(value = "物流商转单号")
    private java.lang.String logisticsOrderNo1;
	/**是否备库订单（0:否 1:是）*/
	@Excel(name = "是否备库订单（0:否 1:是）", width = 15)
    @ApiModelProperty(value = "是否备库订单（0:否 1:是）")
    private java.lang.Integer isStockOrder;
	/**亚马逊备库单ID*/
	@Excel(name = "亚马逊备库单ID", width = 15)
    @ApiModelProperty(value = "亚马逊备库单ID")
    private java.lang.String shipmentId;
	/**买家订单号*/
	@Excel(name = "买家订单号", width = 15)
    @ApiModelProperty(value = "买家订单号")
    private java.lang.String sellerOrderId;
	/**订单来源渠道类型*/
	@Excel(name = "订单来源渠道类型", width = 15)
    @ApiModelProperty(value = "订单来源渠道类型")
    private java.lang.Integer orderSourceType;
	/**实际发货时间*/
	@Excel(name = "实际发货时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "实际发货时间")
    private java.util.Date shipTime;
	/**是否加密（0:未加密 1:已加密）*/
	@Excel(name = "是否加密（0:未加密 1:已加密）", width = 15)
    @ApiModelProperty(value = "是否加密（0:未加密 1:已加密）")
    private java.lang.Integer encrypted;
	/**门牌号码*/
	@Excel(name = "门牌号码", width = 15)
    @ApiModelProperty(value = "门牌号码")
    private java.lang.String houseNumber;
	/**包裹IDs（多个用逗号分隔）*/
	@Excel(name = "包裹IDs（多个用逗号分隔）", width = 15)
    @ApiModelProperty(value = "包裹IDs（多个用逗号分隔）")
    private java.lang.String packagedIds;
}
