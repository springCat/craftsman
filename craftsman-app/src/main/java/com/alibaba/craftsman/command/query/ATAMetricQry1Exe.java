package com.alibaba.craftsman.command.query;

import com.alibaba.cola.command.CommandExecutorI;
import com.alibaba.cola.command.Phase;
import com.alibaba.cola.command.QueryExecutorI;
import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.craftsman.dto.ATAMetricQry;
import com.alibaba.craftsman.dto.clientobject.ATAMetricCO;
import org.springframework.beans.factory.annotation.Autowired;

@Phase
public class ATAMetricQry1Exe implements QueryExecutorI<Response, ATAMetricQry> {

    @Autowired
    private ATAMetricQry2Exe ataMetricQry2Exe;

    @Override
    public MultiResponse<ATAMetricCO> execute(ATAMetricQry cmd) {
        return ataMetricQry2Exe.execute(cmd);
    }

}
