package com.alibaba.craftsman.service;

import cn.hutool.aop.ProxyUtil;
import com.alibaba.cola.command.CommandBusI;
import com.alibaba.cola.common.ApplicationContextHelper;
import com.alibaba.cola.dto.Command;
import com.alibaba.craftsman.api.MetricsServiceI;
import com.alibaba.craftsman.dto.CommonCommand;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Description ServiceInvoke
 * @Author springCat
 * @Date 2020/7/24 10:00
 */
public class ServiceInvoker {

    public Object getServiceInvoker(Class cls) {
        return ProxyUtil.newProxyInstance(new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                CommandBusI commandBus = (CommandBusI) ApplicationContextHelper.getBean("commandBus");
                for (Object arg : args) {
                    if (arg instanceof CommonCommand) {
                        return commandBus.send((Command) arg);
                    }
                }
                return null;
            }
        },cls);
    }
}
