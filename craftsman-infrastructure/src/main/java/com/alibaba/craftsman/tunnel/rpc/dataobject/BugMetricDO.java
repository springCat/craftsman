package com.alibaba.craftsman.tunnel.rpc.dataobject;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BugMetricDO {
    private int bugCount; //缺陷数量
    private long checkInCodeCount; //check in的代码量
}
