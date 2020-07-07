package com.alibaba.craftsman.tunnel.database.craftsman1;

import com.alibaba.craftsman.tunnel.database.craftsman.dataobject.MetricDO;
import com.alibaba.craftsman.tunnel.database.craftsman1.dataobject.MetricDO1;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.FileNotFoundException;

/**
 * @Description MetricTunnel1Test
 * @Author springCat
 * @Date 2020/7/7 18:47
 */
public class MetricTunnel1Test {
    private static MetricTunnel1 mapper;

    @BeforeClass
    public static void setUpMybatisDatabase() {
        SqlSessionFactory builder = new SqlSessionFactoryBuilder().build(MetricTunnel1Test.class.getClassLoader().getResourceAsStream("mybatisTestConfiguration/MetricTunnel1TestConfiguration.xml"));
        //you can use builder.openSession(false) to not commit to database
        mapper = builder.getConfiguration().getMapper(MetricTunnel1.class, builder.openSession(true));
    }

    @Test
    public void testCreate() throws FileNotFoundException {
        MetricDO1 metricDO1 = new MetricDO1();
        metricDO1.setMainMetric("mainTest");
        metricDO1.setSubMetric("subTest");
        metricDO1.setUserId("12346");
        metricDO1.setMetricItem("{\"patentName\": \"Leads重构\", \"level\": \"PROJECT\"}");
        metricDO1.setCreator("creator");
        metricDO1.setModifier("modifier");
        mapper.create(metricDO1);
    }
}
