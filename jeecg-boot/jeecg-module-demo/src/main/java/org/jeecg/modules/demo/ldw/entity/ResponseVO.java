package org.jeecg.modules.demo.ldw.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
public class ResponseVO  implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 上一页的页码
     */
    private Integer lastNumber;

    /**
     * 当前页码
     */
    private Integer current;

    /**
     * 每页显示条数
     */
    private Integer pageSize;

    /**
     * 总记录数
     */
    private Integer totalCount;


    /**
     * 数据
     */
    private List data;


}
