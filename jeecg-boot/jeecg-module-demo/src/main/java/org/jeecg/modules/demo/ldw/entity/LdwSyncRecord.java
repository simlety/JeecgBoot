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
 * @Description: ldw_sync_record
 * @Author: jeecg-boot
 * @Date:   2025-03-16
 * @Version: V1.0
 */
@Data
@TableName("ldw_sync_record")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="ldw_sync_record对象", description="ldw_sync_record")
public class LdwSyncRecord implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键ID（雪花算法生成）*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键ID（雪花算法生成）")
    private java.lang.Integer id;
	/**目标表名（冗余存储便于快速定位）*/
	@Excel(name = "目标表名（冗余存储便于快速定位）", width = 15)
    @ApiModelProperty(value = "目标表名（冗余存储便于快速定位）")
    private java.lang.String tableName;
	/**实际执行SQL*/
	@Excel(name = "实际执行SQL", width = 15)
    @ApiModelProperty(value = "实际执行SQL")
    private java.lang.String executedSql;
	/**0-待处理,1-自动重试中,2-人工处理中,3-处理成功,4-永久失败,99-已归档*/
	@Excel(name = "0-待处理,1-自动重试中,2-人工处理中,3-处理成功,4-永久失败,99-已归档", width = 15)
    @ApiModelProperty(value = "0-待处理,1-自动重试中,2-人工处理中,3-处理成功,4-永久失败,99-已归档")
    private java.lang.Integer status;
	/**异常概要信息*/
	@Excel(name = "异常概要信息", width = 15)
    @ApiModelProperty(value = "异常概要信息")
    private java.lang.String errorMessage;
	/**完整异常堆栈（建议JSON格式存储）*/
	@Excel(name = "完整异常堆栈（建议JSON格式存储）", width = 15)
    @ApiModelProperty(value = "完整异常堆栈（建议JSON格式存储）")
    private java.lang.String errorStack;
	/**重试次数*/
	@Excel(name = "重试次数", width = 15)
    @ApiModelProperty(value = "重试次数")
    private java.lang.Integer retryCount;
	/**创建时间（精确到毫秒）*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间（精确到毫秒）")
    private java.util.Date createTime;
	/**更新时间*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间")
    private java.util.Date updateTime;
	/**最后一次重试时间*/
	@Excel(name = "最后一次重试时间", width = 20, format = "yyyy-MM-dd HH:mm:ss")
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "最后一次重试时间")
    private java.util.Date lastRetryTime;
}
