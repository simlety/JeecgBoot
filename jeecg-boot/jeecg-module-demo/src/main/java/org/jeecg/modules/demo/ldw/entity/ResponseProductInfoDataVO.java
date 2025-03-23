package org.jeecg.modules.demo.ldw.entity;

import lombok.Data;

import java.util.List; /**
 * 产品数据类
 */
@Data
public class ResponseProductInfoDataVO {
    /**
     * 产品数据列表
     */
    private List<LdwProductInfo> productInfoList;
    /**
     * 下一个token（用于分页）
     */
    private Integer nextToken;
}
