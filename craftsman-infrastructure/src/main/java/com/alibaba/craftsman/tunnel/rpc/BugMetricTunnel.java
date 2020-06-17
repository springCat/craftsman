package com.alibaba.craftsman.tunnel.rpc;

import com.alibaba.craftsman.tunnel.rpc.dataobject.BugMetricDO;
import org.springframework.stereotype.Component;

/**
 * 模拟一个RPC的Tunnel，也是日常业务中非常常见的场景。
 *
 * 假设Bug数和代码checkin数再另外一个系统中，没有存在本地，需要通过RPC调用才能获取。
 *
 */
@Component
public class BugMetricTunnel {

    /**
     *  Dummy RPC Call
     */
    public BugMetricDO getByUserId(String userId){
        return BugMetricDO.builder()
                .bugCount(3)
                .checkInCodeCount(1500)
                .build();
    }
}
