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
 * @Description: ldw_sys_config
 * @Author: jeecg-boot
 * @Date:   2025-03-24
 * @Version: V1.0
 */
@Data
@TableName("ldw_sys_config")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="ldw_sys_config对象", description="ldw_sys_config")
public class LdwSysConfig implements Serializable {
    private static final long serialVersionUID = 1L;

	/**自增主键*/
	@TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "自增主键")
    private java.lang.Integer id;
	/**配置键（唯一标识）*/
	@Excel(name = "配置键（唯一标识）", width = 15)
    @ApiModelProperty(value = "配置键（唯一标识）")
    private java.lang.String configKey;
	/**配置值*/
	@Excel(name = "配置值", width = 15)
    @ApiModelProperty(value = "配置值")
    private java.lang.String configValue;
	/**配置描述*/
	@Excel(name = "配置描述", width = 15)
    @ApiModelProperty(value = "配置描述")
    private java.lang.String description;
	/**状态（0-禁用 1-启用）*/
	@Excel(name = "状态（0-禁用 1-启用）", width = 15)
    @ApiModelProperty(value = "状态（0-禁用 1-启用）")
    private java.lang.Integer status;
	/**创建人*/
    @ApiModelProperty(value = "创建人")
    private java.lang.String createBy;
	/**创建日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建日期")
    private java.util.Date createTime;
	/**更新人*/
    @ApiModelProperty(value = "更新人")
    private java.lang.String updateBy;
	/**更新日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新日期")
    private java.util.Date updateTime;
	/**所属部门*/
    @ApiModelProperty(value = "所属部门")
    private java.lang.String sysOrgCode;
}
