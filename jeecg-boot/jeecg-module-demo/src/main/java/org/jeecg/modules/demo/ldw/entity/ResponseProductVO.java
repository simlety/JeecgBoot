package org.jeecg.modules.demo.ldw.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
public class ResponseProductVO implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 数据
     */
    private ResponseProductInfoDataVO data;

    /**
     * 状态
     */
    private String status;

    /**
     * 消息
     */
    private String message;


}

