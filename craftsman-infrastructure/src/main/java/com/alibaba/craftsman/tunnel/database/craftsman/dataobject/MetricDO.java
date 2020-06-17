package com.alibaba.craftsman.tunnel.database.craftsman.dataobject;

import lombok.Data;

import java.util.Date;

@Data
public class MetricDO{
    private String id;
    /**
     * 域账号
     */
    private String userId;
    /**
     * 主度量
     */
    private String mainMetric;
    /**
     * 子度量
     */
    private String subMetric;
    /**
     * 度量条目
     */
    private String metricItem;

    private String creator;

    private String modifier;

    private Date gmtCreate;

    private Date gmtModified;

    private Boolean isDeleted;


}
