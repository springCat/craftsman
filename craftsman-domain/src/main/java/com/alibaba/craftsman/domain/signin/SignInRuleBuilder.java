package com.alibaba.craftsman.domain.signin;

import java.util.Date;

/**
 * @Description RuleFactory
 * @Author springCat
 * @Date 2020/6/12 9:26
 */
public abstract class SignInRuleBuilder {

    private RuleType ruleType;

    private Date ruleStartTime;

    private Date ruleEndTime;

    private String fixedMonth;

    public abstract SignInRule build();
}
