package com.alibaba.craftsman.tunnel;

import com.alibaba.craftsman.domain.metrics.MainMetricType;
import com.alibaba.craftsman.domain.metrics.SubMetricType;
import com.alibaba.craftsman.tunnel.database.craftsman.MetricTunnel;
import com.alibaba.craftsman.tunnel.database.craftsman.dataobject.MetricDO;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * This is Tunnel Test, no need to mock, and no regression needed as well
 *
 * @author Frank Zhang
 * @date 2019-02-27 2:33 PM
 */
public class MetricTunnelTest {

    @Autowired
    private MetricTunnel metricTunnel;

    public void testCRUD(){
        String userId = "MetricTunnelTest" + Math.random();
        MetricDO metricDO = new MetricDO();
        metricDO.setMainMetric(MainMetricType.TECH_INFLUENCE.getMetricCode());
        metricDO.setSubMetric(SubMetricType.Refactoring.getMetricSubTypeCode());
        metricDO.setUserId(userId);
        metricDO.setMetricItem("{\"patentName\": \"Leads重构\", \"level\": \"PROJECT\"}");

        metricTunnel.create(metricDO);

        List<MetricDO> metricDOS = metricTunnel.listByUserId(userId);
        Assert.assertEquals(1, metricDOS.size());

        metricTunnel.delete(metricDOS.get(0).getId(),"MetricTunnelTest");
        Assert.assertEquals(0, metricTunnel.listByUserId(userId).size());
    }
}
