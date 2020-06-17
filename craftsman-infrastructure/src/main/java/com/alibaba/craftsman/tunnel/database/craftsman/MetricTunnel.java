package com.alibaba.craftsman.tunnel.database.craftsman;

import com.alibaba.craftsman.tunnel.database.craftsman.dataobject.MetricDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MetricTunnel {

    int create(MetricDO dataObject);

    List<MetricDO> listByUserId(String userId);

    List<MetricDO> listByMainMetric(String userId, String mainMetric);

    List<MetricDO> listBySubMetric(String userId,String subMetric);

    int delete(String id,String modifier);

    MetricDO getById(String id);
}
