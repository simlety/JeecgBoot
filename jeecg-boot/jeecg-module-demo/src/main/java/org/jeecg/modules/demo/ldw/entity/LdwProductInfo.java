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
 * @Description: ldw_product_info
 * @Author: jeecg-boot
 * @Date:   2025-03-16
 * @Version: V1.0
 */
@Data
@TableName("ldw_product_info")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="ldw_product_info对象", description="ldw_product_info")
public class LdwProductInfo implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "主键")
    private java.lang.Integer id;
	/**系统SKU|产品编码*/
	@Excel(name = "系统SKU|产品编码", width = 15)
    @ApiModelProperty(value = "系统SKU|产品编码")
    private java.lang.String sku;
	/**自定义SKU*/
	@Excel(name = "自定义SKU", width = 15)
    @ApiModelProperty(value = "自定义SKU")
    private java.lang.String clientSku;
	/**产品英文名*/
	@Excel(name = "产品英文名", width = 15)
    @ApiModelProperty(value = "产品英文名")
    private java.lang.String productName;
	/**产品特点*/
	@Excel(name = "产品特点", width = 15)
    @ApiModelProperty(value = "产品特点")
    private java.lang.String featureList;
	/**包装清单*/
	@Excel(name = "包装清单", width = 15)
    @ApiModelProperty(value = "包装清单")
    private java.lang.String packingList;
	/**产品颜色属性*/
	@Excel(name = "产品颜色属性", width = 15)
    @ApiModelProperty(value = "产品颜色属性")
    private java.lang.String productColor;
	/**产品尺码属性*/
	@Excel(name = "产品尺码属性", width = 15)
    @ApiModelProperty(value = "产品尺码属性")
    private java.lang.String productSize;
	/**产品净重(g)*/
	@Excel(name = "产品净重(g)", width = 15)
    @ApiModelProperty(value = "产品净重(g)")
    private java.math.BigDecimal netWeight;
	/**产品毛重(g)*/
	@Excel(name = "产品毛重(g)", width = 15)
    @ApiModelProperty(value = "产品毛重(g)")
    private java.math.BigDecimal grossWeight;
	/**销售价*/
	@Excel(name = "销售价", width = 15)
    @ApiModelProperty(value = "销售价")
    private java.math.BigDecimal salePrice;
	/**库存数量*/
	@Excel(name = "库存数量", width = 15)
    @ApiModelProperty(value = "库存数量")
    private java.lang.Integer goodNum;
	/**B2C页面Title*/
	@Excel(name = "B2C页面Title", width = 15)
    @ApiModelProperty(value = "B2C页面Title")
    private java.lang.String pageTitle;
	/**B2C页面关键词描述*/
	@Excel(name = "B2C页面关键词描述", width = 15)
    @ApiModelProperty(value = "B2C页面关键词描述")
    private java.lang.String mateDescription;
	/**B2C页面关键词*/
	@Excel(name = "B2C页面关键词", width = 15)
    @ApiModelProperty(value = "B2C页面关键词")
    private java.lang.String mateKeyword;
	/**搜索关键词*/
	@Excel(name = "搜索关键词", width = 15)
    @ApiModelProperty(value = "搜索关键词")
    private java.lang.String searchKeyword;
	/**产品报关名*/
	@Excel(name = "产品报关名", width = 15)
    @ApiModelProperty(value = "产品报关名")
    private java.lang.String declarationName;
	/**产品报关中文名*/
	@Excel(name = "产品报关中文名", width = 15)
    @ApiModelProperty(value = "产品报关中文名")
    private java.lang.String declarationNameCn;
	/**产品报关材质*/
	@Excel(name = "产品报关材质", width = 15)
    @ApiModelProperty(value = "产品报关材质")
    private java.lang.String declarationMaterial;
	/**产品报关价*/
	@Excel(name = "产品报关价", width = 15)
    @ApiModelProperty(value = "产品报关价")
    private java.math.BigDecimal declarationPriceRate;
	/**产品上架状态*/
	@Excel(name = "产品上架状态", width = 15)
    @ApiModelProperty(value = "产品上架状态")
    private java.lang.String onlineStatus;
	/**最新供货价*/
	@Excel(name = "最新供货价", width = 15)
    @ApiModelProperty(value = "最新供货价")
    private java.math.BigDecimal lastSupplierPrice;
	/**产品最新采购价*/
	@Excel(name = "产品最新采购价", width = 15)
    @ApiModelProperty(value = "产品最新采购价")
    private java.math.BigDecimal lastBuyPrice;
	/**产品单件采购运费*/
	@Excel(name = "产品单件采购运费", width = 15)
    @ApiModelProperty(value = "产品单件采购运费")
    private java.math.BigDecimal unitShipFee;
	/**产品长(cm)*/
	@Excel(name = "产品长(cm)", width = 15)
    @ApiModelProperty(value = "产品长(cm)")
    private java.math.BigDecimal length;
	/**产品宽(cm)*/
	@Excel(name = "产品宽(cm)", width = 15)
    @ApiModelProperty(value = "产品宽(cm)")
    private java.math.BigDecimal width;
	/**产品高(cm)*/
	@Excel(name = "产品高(cm)", width = 15)
    @ApiModelProperty(value = "产品高(cm)")
    private java.math.BigDecimal height;
	/**包装长(cm)*/
	@Excel(name = "包装长(cm)", width = 15)
    @ApiModelProperty(value = "包装长(cm)")
    private java.math.BigDecimal packLength;
	/**包装宽(cm)*/
	@Excel(name = "包装宽(cm)", width = 15)
    @ApiModelProperty(value = "包装宽(cm)")
    private java.math.BigDecimal packWidth;
	/**包装高(cm)*/
	@Excel(name = "包装高(cm)", width = 15)
    @ApiModelProperty(value = "包装高(cm)")
    private java.math.BigDecimal packHeight;
	/**侵权风险*/
	@Excel(name = "侵权风险", width = 15)
    @ApiModelProperty(value = "侵权风险")
    private java.lang.String productProperty;
	/**物流属性*/
	@Excel(name = "物流属性", width = 15)
    @ApiModelProperty(value = "物流属性")
    private java.lang.String withBattery;
	/**产品更新时间*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "产品更新时间")
    private java.util.Date updateTime;
	/**产品图片更新时间*/
	@Excel(name = "产品图片更新时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "产品图片更新时间")
    private java.util.Date updateImageDateTime;
	/**母体ID*/
	@Excel(name = "母体ID", width = 15)
    @ApiModelProperty(value = "母体ID")
    private java.lang.String productGroupSku;
	/**一级分类ID*/
	@Excel(name = "一级分类ID", width = 15)
    @ApiModelProperty(value = "一级分类ID")
    private java.lang.Integer classId1;
	/**二级分类ID*/
	@Excel(name = "二级分类ID", width = 15)
    @ApiModelProperty(value = "二级分类ID")
    private java.lang.Integer classId2;
	/**最后一级分类ID*/
	@Excel(name = "最后一级分类ID", width = 15)
    @ApiModelProperty(value = "最后一级分类ID")
    private java.lang.Integer lastClassId;
	/**完整英文分类*/
	@Excel(name = "完整英文分类", width = 15)
    @ApiModelProperty(value = "完整英文分类")
    private java.lang.String fullClassNameEn;
	/**产品中文名*/
	@Excel(name = "产品中文名", width = 15)
    @ApiModelProperty(value = "产品中文名")
    private java.lang.String productNameCn;
	/**上架时间*/
	@Excel(name = "上架时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "上架时间")
    private java.util.Date onlineTime;
	/**添加时间*/
	@Excel(name = "添加时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "添加时间")
    private java.util.Date addTime;
	/**开发人员*/
	@Excel(name = "开发人员", width = 15)
    @ApiModelProperty(value = "开发人员")
    private java.lang.String developAdminName;
	/**采购人员*/
	@Excel(name = "采购人员", width = 15)
    @ApiModelProperty(value = "采购人员")
    private java.lang.String buyerName;
	/**供应商*/
	@Excel(name = "供应商", width = 15)
    @ApiModelProperty(value = "供应商")
    private java.lang.String supplierName;
	/**供应商ID*/
	@Excel(name = "供应商ID", width = 15)
    @ApiModelProperty(value = "供应商ID")
    private java.lang.Integer supplierId;
	/**封面缩略图URL*/
	@Excel(name = "封面缩略图URL", width = 15)
    @ApiModelProperty(value = "封面缩略图URL")
    private java.lang.String smallImageUrl;
	/**产品来源*/
	@Excel(name = "产品来源", width = 15)
    @ApiModelProperty(value = "产品来源")
    private java.lang.String comeSource;
	/**开发类型*/
	@Excel(name = "开发类型", width = 15)
    @ApiModelProperty(value = "开发类型")
    private java.lang.String developType;
	/**图片来源*/
	@Excel(name = "图片来源", width = 15)
    @ApiModelProperty(value = "图片来源")
    private java.lang.String pictureSource;
	/**外箱长(cm)*/
	@Excel(name = "外箱长(cm)", width = 15)
    @ApiModelProperty(value = "外箱长(cm)")
    private java.math.BigDecimal cartonLength;
	/**外箱宽(cm)*/
	@Excel(name = "外箱宽(cm)", width = 15)
    @ApiModelProperty(value = "外箱宽(cm)")
    private java.math.BigDecimal cartonWidth;
	/**外箱高(cm)*/
	@Excel(name = "外箱高(cm)", width = 15)
    @ApiModelProperty(value = "外箱高(cm)")
    private java.math.BigDecimal cartonHeight;
	/**每箱数量*/
	@Excel(name = "每箱数量", width = 15)
    @ApiModelProperty(value = "每箱数量")
    private java.lang.Integer cartonPcsNum;
	/**整箱毛重(kg)*/
	@Excel(name = "整箱毛重(kg)", width = 15)
    @ApiModelProperty(value = "整箱毛重(kg)")
    private java.math.BigDecimal cartonGrossWeight;
	/**整箱净重(kg)*/
	@Excel(name = "整箱净重(kg)", width = 15)
    @ApiModelProperty(value = "整箱净重(kg)")
    private java.math.BigDecimal cartonNetWeight;
	/**产品状态*/
	@Excel(name = "产品状态", width = 15)
    @ApiModelProperty(value = "产品状态")
    private java.lang.String productState;
	/**采购链接*/
	@Excel(name = "采购链接", width = 15)
    @ApiModelProperty(value = "采购链接")
    private java.lang.String webProductUrl;
	/**开发审核状态*/
	@Excel(name = "开发审核状态", width = 15)
    @ApiModelProperty(value = "开发审核状态")
    private java.lang.String developStatus;
	/**编辑审核状态*/
	@Excel(name = "编辑审核状态", width = 15)
    @ApiModelProperty(value = "编辑审核状态")
    private java.lang.String editStatus;
	/**图片审核状态*/
	@Excel(name = "图片审核状态", width = 15)
    @ApiModelProperty(value = "图片审核状态")
    private java.lang.String imageStatus;
	/**终审状态*/
	@Excel(name = "终审状态", width = 15)
    @ApiModelProperty(value = "终审状态")
    private java.lang.String checkStatus;
	/**一级类目中文*/
	@Excel(name = "一级类目中文", width = 15)
    @ApiModelProperty(value = "一级类目中文")
    private java.lang.String classNameCn1;
	/**日均销量*/
	@Excel(name = "日均销量", width = 15)
    @ApiModelProperty(value = "日均销量")
    private java.math.BigDecimal avgDailySales;
	/**产品活跃度*/
	@Excel(name = "产品活跃度", width = 15)
    @ApiModelProperty(value = "产品活跃度")
    private java.lang.String productVitalityType;
	/**新品类型*/
	@Excel(name = "新品类型", width = 15)
    @ApiModelProperty(value = "新品类型")
    private java.lang.String productNewType;
	/**产品用途*/
	@Excel(name = "产品用途", width = 15)
    @ApiModelProperty(value = "产品用途")
    private java.lang.String declarationPurpose;
	/**图片处理人员*/
	@Excel(name = "图片处理人员", width = 15)
    @ApiModelProperty(value = "图片处理人员")
    private java.lang.String imageAdminName;
	/**产品编辑人员*/
	@Excel(name = "产品编辑人员", width = 15)
    @ApiModelProperty(value = "产品编辑人员")
    private java.lang.String editAdminName;
	/**海关编码*/
	@Excel(name = "海关编码", width = 15)
    @ApiModelProperty(value = "海关编码")
    private java.lang.String declarationCode;
	/**退税率*/
	@Excel(name = "退税率", width = 15)
    @ApiModelProperty(value = "退税率")
    private java.math.BigDecimal taxRate;
	/**包裹重量(kg)*/
	@Excel(name = "包裹重量(kg)", width = 15)
    @ApiModelProperty(value = "包裹重量(kg)")
    private java.math.BigDecimal packWeight;
	/**终审用户ID*/
	@Excel(name = "终审用户ID", width = 15)
    @ApiModelProperty(value = "终审用户ID")
    private java.lang.Integer checkAdminId;
	/**终审用户姓名*/
	@Excel(name = "终审用户姓名", width = 15)
    @ApiModelProperty(value = "终审用户姓名")
    private java.lang.String checkAdminName;
	/**开发备注*/
	@Excel(name = "开发备注", width = 15)
    @ApiModelProperty(value = "开发备注")
    private java.lang.String toDevelopMemo;
	/**禁售平台*/
	@Excel(name = "禁售平台", width = 15)
    @ApiModelProperty(value = "禁售平台")
    private java.lang.String noSalePlatform;
	/**品牌*/
	@Excel(name = "品牌", width = 15)
    @ApiModelProperty(value = "品牌")
    private java.lang.String brandName;
	/**是否组合产品*/
	@Excel(name = "是否组合产品", width = 15)
    @ApiModelProperty(value = "是否组合产品")
    private java.lang.Integer isGroup;
	/**规格型号*/
	@Excel(name = "规格型号", width = 15)
    @ApiModelProperty(value = "规格型号")
    private java.lang.String productSpec;
}
