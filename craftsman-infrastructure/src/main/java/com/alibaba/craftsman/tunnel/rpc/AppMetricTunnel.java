package com.alibaba.craftsman.tunnel.rpc;

import com.alibaba.craftsman.tunnel.rpc.dataobject.AppMetricDO;
import org.springframework.stereotype.Component;
import java.util.Arrays;
import java.util.List;

@Component
public class AppMetricTunnel {

    /**
     *  Dummy RPC Call
     */
    public List<AppMetricDO> listByUserId(String userId){

        AppMetricDO appMetricDO1 = AppMetricDO.builder()
                .appName("app1")
                .cyclomaticComplexityCount(200)
                .duplicatedMethodCount(80)
                .longMethodCount(70)
                .blockedCodeConductCount(20).build();

        AppMetricDO appMetricDO12 = AppMetricDO.builder()
                .appName("app2")
                .cyclomaticComplexityCount(20)
                .duplicatedMethodCount(30)
                .longMethodCount(7)
                .blockedCodeConductCount(5).build();

        return Arrays.asList(appMetricDO1,appMetricDO12);
    }
}
