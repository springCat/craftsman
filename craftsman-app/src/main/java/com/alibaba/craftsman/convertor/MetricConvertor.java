package com.alibaba.craftsman.convertor;


import com.alibaba.cola.convertor.ConvertorI;
import com.alibaba.craftsman.domain.metrics.MetricItem;
import com.alibaba.craftsman.tunnel.database.craftsman.dataobject.MetricDO;

/**
 * @author frankzhang
 */
public class MetricConvertor implements ConvertorI {

    public static MetricDO toDataObject(MetricItem metricItem){
        MetricDO metricDO = new MetricDO();
        metricDO.setUserId(metricItem.getMetricOwner().getUserId());
        metricDO.setMainMetric(metricItem.getSubMetric().getParent().getCode());
        metricDO.setSubMetric(metricItem.getSubMetric().getCode());
        metricDO.setMetricItem(metricItem.toJsonString());
        metricDO.setCreator("xiaoming");
        metricDO.setModifier("xiaoming");
        return metricDO;
    }

}
