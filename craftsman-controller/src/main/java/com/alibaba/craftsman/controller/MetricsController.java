package com.alibaba.craftsman.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.alibaba.cola.common.ApplicationContextHelper;
import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import com.alibaba.craftsman.api.MetricsServiceI;
import com.alibaba.craftsman.dto.ATAMetricAddCmd;
import com.alibaba.craftsman.dto.ATAMetricQry;
import com.alibaba.craftsman.dto.clientobject.ATAMetricCO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

@RestController
public class MetricsController {

    @Autowired
    private MetricsServiceI metricsService;

    @GetMapping(value = "/metrics/ata")
    public MultiResponse<ATAMetricCO> listATAMetrics(@RequestParam String ownerId){
        ATAMetricQry ataMetricQry = new ATAMetricQry();
        ataMetricQry.setOwnerId(ownerId);
        return metricsService.listATAMetrics(ataMetricQry);
    }

    @PostMapping(value = "/metrics/ata")
    public Response addATAMetric(@RequestBody ATAMetricAddCmd ataMetricAddCmd){
        return metricsService.addATAMetric(ataMetricAddCmd);
    }

    @PostMapping(value = "/{service}/{method}")
    public Object invoke(@RequestBody String requestBody,@NotNull @PathVariable String service,@NotNull @PathVariable String method){
        Object bean = ApplicationContextHelper.getBean(service);
        Method methodByName = ReflectUtil.getMethodByName(bean.getClass(), method);
        Object params = null;

        if(requestBody != null) {
            if(methodByName.getParameterCount() == 1){
                Parameter[] methodDefineParameters = methodByName.getParameters();
                params = JSONUtil.toBean(requestBody, methodDefineParameters[0].getType());
            }else{
                throw new RuntimeException("only support single argument method");
            }
        }

        return ReflectUtil.invoke(bean,method,params);
    }
}
