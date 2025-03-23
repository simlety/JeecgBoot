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
 * @Description: ldw_ebay_listings
 * @Author: jeecg-boot
 * @Date:   2025-03-23
 * @Version: V1.0
 */
@Data
@TableName("ldw_ebay_listings")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="ldw_ebay_listings对象", description="ldw_ebay_listings")
public class LdwEbayListings implements Serializable {
    private static final long serialVersionUID = 1L;

	/**自增主键，唯一标识记录*/
	@TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "自增主键，唯一标识记录")
    private java.lang.Integer id;
	/**业务系统原始ID（需保持唯一性）*/
	@Excel(name = "业务系统原始ID（需保持唯一性）", width = 15)
    @ApiModelProperty(value = "业务系统原始ID（需保持唯一性）")
    private java.lang.Integer listingBasicId;
	/**来源渠道ID（关联渠道配置表）*/
	@Excel(name = "来源渠道ID（关联渠道配置表）", width = 15)
    @ApiModelProperty(value = "来源渠道ID（关联渠道配置表）")
    private java.lang.Integer orderSourceId;
	/**渠道名称（如eBay德国站）*/
	@Excel(name = "渠道名称（如eBay德国站）", width = 15)
    @ApiModelProperty(value = "渠道名称（如eBay德国站）")
    private java.lang.String orderSourceName;
	/**系统SKU（最大长度50字符，唯一商品编码）*/
	@Excel(name = "系统SKU（最大长度50字符，唯一商品编码）", width = 15)
    @ApiModelProperty(value = "系统SKU（最大长度50字符，唯一商品编码）")
    private java.lang.String sku;
	/**渠道SKU（平台侧商品编码，最大长度100）*/
	@Excel(name = "渠道SKU（平台侧商品编码，最大长度100）", width = 15)
    @ApiModelProperty(value = "渠道SKU（平台侧商品编码，最大长度100）")
    private java.lang.String orderSourceSku;
	/**平台商品ID（eBay API返回的ItemID）*/
	@Excel(name = "平台商品ID（eBay API返回的ItemID）", width = 15)
    @ApiModelProperty(value = "平台商品ID（eBay API返回的ItemID）")
    private java.lang.String itemId;
	/**商品标题（德语，最大长度500字符）*/
	@Excel(name = "商品标题（德语，最大长度500字符）", width = 15)
    @ApiModelProperty(value = "商品标题（德语，最大长度500字符）")
    private java.lang.String productTitle;
	/**站点代码（遵循eBay站点编码规范，如DE）*/
	@Excel(name = "站点代码（遵循eBay站点编码规范，如DE）", width = 15)
    @ApiModelProperty(value = "站点代码（遵循eBay站点编码规范，如DE）")
    private java.lang.String siteCode;
	/**主分类（平台分类体系一级类目）*/
	@Excel(name = "主分类（平台分类体系一级类目）", width = 15)
    @ApiModelProperty(value = "主分类（平台分类体系一级类目）")
    private java.lang.String primaryCategory;
	/**二级分类（平台分类体系二级类目）*/
	@Excel(name = "二级分类（平台分类体系二级类目）", width = 15)
    @ApiModelProperty(value = "二级分类（平台分类体系二级类目）")
    private java.lang.String secondaryCategory;
	/**完整分类路径（平台分类全路径，分隔符:）*/
	@Excel(name = "完整分类路径（平台分类全路径，分隔符:）", width = 15)
    @ApiModelProperty(value = "完整分类路径（平台分类全路径，分隔符:）")
    private java.lang.String allCategory;
	/**一级产品类目（内部产品类目体系）*/
	@Excel(name = "一级产品类目（内部产品类目体系）", width = 15)
    @ApiModelProperty(value = "一级产品类目（内部产品类目体系）")
    private java.lang.String primaryProductCategory;
	/**二级产品类目（内部产品类目体系）*/
	@Excel(name = "二级产品类目（内部产品类目体系）", width = 15)
    @ApiModelProperty(value = "二级产品类目（内部产品类目体系）")
    private java.lang.String secondaryProductCategory;
	/**三级产品类目（内部产品类目体系）*/
	@Excel(name = "三级产品类目（内部产品类目体系）", width = 15)
    @ApiModelProperty(value = "三级产品类目（内部产品类目体系）")
    private java.lang.String threeProductCategory;
	/**完整产品类目路径（内部分类全路径）*/
	@Excel(name = "完整产品类目路径（内部分类全路径）", width = 15)
    @ApiModelProperty(value = "完整产品类目路径（内部分类全路径）")
    private java.lang.String allProductCategory;
	/**中文产品名称（最大长度300字符）*/
	@Excel(name = "中文产品名称（最大长度300字符）", width = 15)
    @ApiModelProperty(value = "中文产品名称（最大长度300字符）")
    private java.lang.String productNameCn;
	/**销售价格（含小数点精度，最大9999999999.99）*/
	@Excel(name = "销售价格（含小数点精度，最大9999999999.99）", width = 15)
    @ApiModelProperty(value = "销售价格（含小数点精度，最大9999999999.99）")
    private java.math.BigDecimal sellingPrice;
	/**货币代码（ISO 4217标准，如EUR/USD）*/
	@Excel(name = "货币代码（ISO 4217标准，如EUR/USD）", width = 15)
    @ApiModelProperty(value = "货币代码（ISO 4217标准，如EUR/USD）")
    private java.lang.String currency;
	/**周销量（自然周统计，自动更新）*/
	@Excel(name = "周销量（自然周统计，自动更新）", width = 15)
    @ApiModelProperty(value = "周销量（自然周统计，自动更新）")
    private java.lang.Integer salesWeek;
	/**两周销量（滚动统计周期）*/
	@Excel(name = "两周销量（滚动统计周期）", width = 15)
    @ApiModelProperty(value = "两周销量（滚动统计周期）")
    private java.lang.Integer salesTwoWeek;
	/**月销量（自然月统计）*/
	@Excel(name = "月销量（自然月统计）", width = 15)
    @ApiModelProperty(value = "月销量（自然月统计）")
    private java.lang.Integer salesMonth;
	/**三月销量（季度滚动统计）*/
	@Excel(name = "三月销量（季度滚动统计）", width = 15)
    @ApiModelProperty(value = "三月销量（季度滚动统计）")
    private java.lang.Integer salesThreeMonth;
	/**上架时间（UTC时区，格式：YYYY-MM-DD HH:MM:SS）*/
	@Excel(name = "上架时间（UTC时区，格式：YYYY-MM-DD HH:MM:SS）", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "上架时间（UTC时区，格式：YYYY-MM-DD HH:MM:SS）")
    private java.util.Date onSelfTime;
	/**下架时间（UTC时区，自动记录）*/
	@Excel(name = "下架时间（UTC时区，自动记录）", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "下架时间（UTC时区，自动记录）")
    private java.util.Date soldOutTime;
	/**添加人（员工账号名称，AD账号）*/
	@Excel(name = "添加人（员工账号名称，AD账号）", width = 15)
    @ApiModelProperty(value = "添加人（员工账号名称，AD账号）")
    private java.lang.String addItemAdminName;
	/**业务团队（事业部名称，如3C事业部）*/
	@Excel(name = "业务团队（事业部名称，如3C事业部）", width = 15)
    @ApiModelProperty(value = "业务团队（事业部名称，如3C事业部）")
    private java.lang.String businessTeamName;
	/**刊登费用（平台服务费，货币与currency字段一致）*/
	@Excel(name = "刊登费用（平台服务费，货币与currency字段一致）", width = 15)
    @ApiModelProperty(value = "刊登费用（平台服务费，货币与currency字段一致）")
    private java.math.BigDecimal addItemFee;
	/**在线状态：0-草稿 1-在线 2-刊登中 3-刊登失败 4-手动下架*/
	@Excel(name = "在线状态：0-草稿 1-在线 2-刊登中 3-刊登失败 4-手动下架", width = 15)
    @ApiModelProperty(value = "在线状态：0-草稿 1-在线 2-刊登中 3-刊登失败 4-手动下架")
    private java.lang.Integer status;
	/**商品链接（平台商品详情页URL）*/
	@Excel(name = "商品链接（平台商品详情页URL）", width = 15)
    @ApiModelProperty(value = "商品链接（平台商品详情页URL）")
    private java.lang.String productSellLink;
	/**最后更新时间（自动维护）*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "最后更新时间（自动维护）")
    private java.util.Date updateTime;
	/**变体状态：0-无变体 1-父变体 2-子变体 3-变体异常*/
	@Excel(name = "变体状态：0-无变体 1-父变体 2-子变体 3-变体异常", width = 15)
    @ApiModelProperty(value = "变体状态：0-无变体 1-父变体 2-子变体 3-变体异常")
    private java.lang.Integer variationStatus;
}
