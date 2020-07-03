package com.alibaba.craftsman.command.query;

import com.alibaba.cola.command.Command;
import com.alibaba.cola.command.CommandExecutorI;
import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.extension.BizScenario;
import com.alibaba.cola.extension.ExtensionExecutor;
import com.alibaba.craftsman.dto.ATAMetricQry;
import com.alibaba.craftsman.dto.clientobject.ATAMetricCO;
import com.alibaba.craftsman.point.CountryPrinterExtPt;
import org.springframework.beans.factory.annotation.Autowired;

@Command
public class ATAMetricQryExe implements CommandExecutorI<Response, ATAMetricQry> {

    @Autowired
    private ATAMetricQry1Exe aTAMetricQry1Exe;

    @Autowired
    private ExtensionExecutor extensionExecutor;


    @Override
    public MultiResponse<ATAMetricCO> execute(ATAMetricQry cmd) {

        BizScenario bizScenario = BizScenario.valueOf("1111");
        extensionExecutor.executeVoid(CountryPrinterExtPt.class, bizScenario, p -> p.print());
        return aTAMetricQry1Exe.execute(cmd);
    }

}
