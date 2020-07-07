package com.alibaba.craftsman.tunnel.database.craftsman;

import com.alibaba.craftsman.tunnel.database.craftsman.dataobject.MetricDO;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * @Description MetricTunnelTest
 * @Author springCat
 * @Date 2020/7/7 18:36
 */
public class MetricTunnelTest {

    private static MetricTunnel mapper;

    @BeforeClass
    public static void setUpMybatisDatabase() {
        SqlSessionFactory builder = new SqlSessionFactoryBuilder()
                .build(MetricTunnelTest.class.getClassLoader().getResourceAsStream("mybatisTestConfiguration/MetricTunnelTestConfiguration.xml"));
        mapper = builder.getConfiguration().getMapper(MetricTunnel.class, builder.openSession(true));
    }

    @Test
    public void testCreate() throws FileNotFoundException {
        MetricDO metricDO = new MetricDO();
        metricDO.setMainMetric("mainTest");
        metricDO.setSubMetric("subTest");
        metricDO.setUserId("12345");
        metricDO.setMetricItem("{\"patentName\": \"Leads重构\", \"level\": \"PROJECT\"}");
        metricDO.setCreator("creator");
        metricDO.setModifier("modifier");
        mapper.create(metricDO);
    }

    @Test
    public void testListByUserId() throws FileNotFoundException {

        List<MetricDO> metricDOS = mapper.listByUserId("12345");
        System.out.println(metricDOS);
    }
}
