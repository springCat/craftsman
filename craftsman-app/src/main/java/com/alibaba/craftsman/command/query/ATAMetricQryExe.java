package com.alibaba.craftsman.command.query;

import com.alibaba.cola.command.Command;
import com.alibaba.cola.command.CommandExecutorI;
import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.craftsman.dto.ATAMetricQry;
import com.alibaba.craftsman.dto.clientobject.ATAMetricCO;
import org.springframework.beans.factory.annotation.Autowired;

@Command
public class ATAMetricQryExe implements CommandExecutorI<Response, ATAMetricQry> {

    @Autowired
    private ATAMetricQry1Exe aTAMetricQry1Exe;

    @Override
    public MultiResponse<ATAMetricCO> execute(ATAMetricQry cmd) {
        return aTAMetricQry1Exe.execute(cmd);
    }

}
