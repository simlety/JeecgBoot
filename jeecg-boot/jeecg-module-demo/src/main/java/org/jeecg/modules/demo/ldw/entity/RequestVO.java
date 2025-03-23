package org.jeecg.modules.demo.ldw.entity;

import lombok.Data;

import java.io.Serializable;


@Data
public class RequestVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 每页显示条数
     */
    private Integer pageSize;
    /**
     * 当前页码
     */
    private Integer current;

    /**
     * 开始时间
     */
    private String startTime;

    /**
     * 结束时间
     */
    private String endTime;


    /**
     * 下一个
     */
    private Integer nextToken;

}
