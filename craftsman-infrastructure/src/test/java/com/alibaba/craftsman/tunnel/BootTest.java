package com.alibaba.craftsman.tunnel;

import com.alibaba.craftsman.common.Application;
import com.alibaba.craftsman.common.RuleTest;
import com.alibaba.craftsman.common.dbscript.DbScript;
import com.alibaba.craftsman.common.dbscript.DbScripts;
import com.alibaba.craftsman.common.dbscript.DbScriptRule;
import com.alibaba.craftsman.config.DataSourceType;
import com.alibaba.craftsman.tunnel.database.craftsman.MetricTunnel;
import com.alibaba.craftsman.tunnel.database.craftsman.dataobject.MetricDO;;
import lombok.SneakyThrows;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * MybatisTest
 *
 * @author Frank Zhang
 * @date 2019-02-27 4:38 PM
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
public class BootTest extends RuleTest {

    @Autowired
    private MetricTunnel metricTunnel;

    @SneakyThrows
    @Test
    @DbScript(databaseName = DataSourceType.craftsman,initSql = "1.sql",cleanSql = "2.sql")
    public void insert() {
        MetricDO metricDO = new MetricDO();
        metricDO.setMainMetric("mainTest");
        metricDO.setSubMetric("subTest");
        metricDO.setUserId("12345");
        metricDO.setMetricItem("{\"patentName\": \"Leads重构\", \"level\": \"PROJECT\"}");
        metricDO.setCreator("creator");
        metricDO.setModifier("modifier");
        metricTunnel.create(metricDO);
        System.out.println("");
    }


}
