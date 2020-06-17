package com.alibaba.craftsman.tunnel.database.craftsman1;

import com.alibaba.craftsman.tunnel.database.craftsman1.dataobject.MetricDO1;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MetricTunnel1 {

    int create(MetricDO1 dataObject);

    List<MetricDO1> listByUserId(String userId);

    List<MetricDO1> listByMainMetric(String userId, String mainMetric);

    List<MetricDO1> listBySubMetric(String userId, String subMetric);

    int delete(String id, String modifier);

    MetricDO1 getById(String id);
}
