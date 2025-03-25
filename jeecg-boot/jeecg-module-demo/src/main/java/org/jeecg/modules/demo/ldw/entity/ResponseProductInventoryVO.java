package org.jeecg.modules.demo.ldw.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
public class ResponseProductInventoryVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 下一页
     */
    private Integer nextToken;


    /**
     * 数据
     */
    private List<LdwProductInventory> productInventoryList;


}
