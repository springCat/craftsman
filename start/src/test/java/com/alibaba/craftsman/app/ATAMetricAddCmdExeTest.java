package com.alibaba.craftsman.app;

import com.alibaba.cola.dto.Response;
import com.alibaba.cola.mock.annotation.ColaMockConfig;
import com.alibaba.cola.mock.annotation.ExcludeCompare;
import com.alibaba.cola.mock.runner.ColaTestRunner;
import com.alibaba.craftsman.api.MetricsServiceI;
import com.alibaba.craftsman.dto.ATAMetricAddCmd;
import com.alibaba.craftsman.dto.clientobject.ATAMetricCO;
import com.alibaba.craftsman.tunnel.database.craftsman.MetricTunnel;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * ATAMetricAddCmdExeTest
 *
 * @author Frank Zhang
 * @date 2019-03-01 6:18 PM
 */
@RunWith(ColaTestRunner.class)
@ColaMockConfig(mocks={MetricTunnel.class})
public class ATAMetricAddCmdExeTest extends MockTestBase {

    @Autowired
    private MetricsServiceI metricsServiceImpl;

    public static ATAMetricAddCmd prepareCommand(){
        ATAMetricAddCmd ataMetricAddCmd = new ATAMetricAddCmd();
        ATAMetricCO ataMetricCO = new ATAMetricCO();
        ataMetricCO.setOwnerId("ATAMetricAddCmdExeTest");
        ataMetricCO.setTitle("testATAMetricAddSuccess");
        ataMetricCO.setUrl("sharingLink");
        ataMetricCO.setCommentCount(14);
        ataMetricCO.setFavoriteCount(49);
        ataMetricCO.setHitCount(299);
        ataMetricCO.setThumbsUpCount(89);
        ataMetricAddCmd.setAtaMetricCO(ataMetricCO);
        return ataMetricAddCmd;
    }

    @Test
    @ExcludeCompare(fields = {"id","userId"})
    public void testATAMetricAddSuccess(){
        ATAMetricAddCmd ataMetricAddCmd = prepareCommand();
        Response response = metricsServiceImpl.addATAMetric(ataMetricAddCmd);
        Assert.assertTrue(response.isSuccess());
    }

    @Test
    public void testATAMetricAddWithoutAuthor(){
        ATAMetricAddCmd ataMetricAddCmd = new ATAMetricAddCmd();
        ATAMetricCO ataMetricCO = new ATAMetricCO();
        ataMetricAddCmd.setAtaMetricCO(ataMetricCO);

        Response response = metricsServiceImpl.addATAMetric(ataMetricAddCmd);

        Assert.assertFalse(response.isSuccess());
    }
}
