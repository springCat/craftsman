package com.alibaba.craftsman.command.query;

import com.alibaba.cola.command.CommandExecutorI;
import com.alibaba.cola.command.QueryExecutorI;
import com.alibaba.cola.command.Step;
import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.craftsman.common.util.TxManager;
import com.alibaba.craftsman.domain.metrics.SubMetricType;
import com.alibaba.craftsman.dto.ATAMetricQry;
import com.alibaba.craftsman.dto.clientobject.ATAMetricCO;
import com.alibaba.craftsman.tunnel.database.craftsman.MetricTunnel;
import com.alibaba.craftsman.tunnel.database.craftsman.dataobject.MetricDO;
import com.alibaba.craftsman.tunnel.database.craftsman1.dataobject.MetricDO1;
import com.alibaba.craftsman.tunnel.database.craftsman1.MetricTunnel1;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Step
public class ATAMetricQry2Exe implements QueryExecutorI<Response, ATAMetricQry> {

    @Autowired
    private MetricTunnel metricTunnel;

    @Autowired
    private MetricTunnel1 metricTunnel1;

    @Autowired
    private TxManager txManager;


    @Override
    public MultiResponse<ATAMetricCO> execute(ATAMetricQry cmd) {
        Supplier<MultiResponse<ATAMetricCO>> supplier =  () -> {
            Page<Object> objects = PageHelper.offsetPage(1, 2, false);
            List<MetricDO> metricDOList = metricTunnel.listBySubMetric(cmd.getOwnerId(), SubMetricType.ATA.getMetricSubTypeCode());
            List<ATAMetricCO> ataMetricCOList = new ArrayList<>();
            metricDOList.forEach(metricDO -> {
                ATAMetricCO ataMetricCO = JSON.parseObject(metricDO.getMetricItem(), ATAMetricCO.class);
                ataMetricCO.setOwnerId(metricDO.getUserId());
                ataMetricCOList.add(ataMetricCO);
            });

            Page<Object> objects2 = PageHelper.offsetPage(1, 10, false);
            List<MetricDO1> metricDOList1 = metricTunnel1.listBySubMetric(cmd.getOwnerId(), SubMetricType.ATA.getMetricSubTypeCode());
            List<ATAMetricCO> ataMetricCOList1 = new ArrayList<>();
            metricDOList1.forEach(metricDO -> {
                ATAMetricCO ataMetricCO = JSON.parseObject(metricDO.getMetricItem(), ATAMetricCO.class);
                ataMetricCO.setOwnerId(metricDO.getUserId());
                ataMetricCOList1.add(ataMetricCO);
            });
            MetricDO metricDO = new MetricDO();
            metricDO.setMainMetric("mainTest");
            metricDO.setSubMetric("ATA");
            metricDO.setUserId("12345");
            metricDO.setMetricItem("{\"patentName\": \"Leads重构\", \"level\": \"PROJECT\"}");
            metricDO.setCreator("creator");
            metricDO.setModifier("modifier");
            metricTunnel.create(metricDO);

            MetricDO1 metricDO1 = new MetricDO1();
            metricDO1.setMainMetric("mainTest1");
            metricDO1.setSubMetric("ATA");
            metricDO1.setUserId("12345");
            metricDO1.setMetricItem("{\"patentName\": \"Leads重构\", \"level\": \"PROJECT\"}");
            metricDO1.setCreator("creator");
            metricDO1.setModifier("modifier");
            metricTunnel1.create(metricDO1);
            doexp();

            return MultiResponse.ofWithoutTotal(ataMetricCOList);
        };

        return txManager.executeCraftsman(txManager.executeCraftsman1(supplier)).get();

//        return supplier.get();
    }


    public void doexp(){
        throw new RuntimeException("xxx");
    }

}
