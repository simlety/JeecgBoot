package org.jeecg.modules.demo.ldw.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
public class ResponseEbayListingsVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 总记录数
     */
    private Integer RecordCount;


    /**
     * 数据
     */
    private List<LdwEbayListings> ebayBasicInformationList;


}
