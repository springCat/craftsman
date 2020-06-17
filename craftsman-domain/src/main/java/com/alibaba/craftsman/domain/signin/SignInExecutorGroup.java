package com.alibaba.craftsman.domain.signin;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Description ExecutorUnit
 * @Author springCat
 * @Date 2020/6/12 10:47
 */
public abstract class SignInExecutorGroup{

    private List<SignInExecutorUnit> signInRuleList;

    public void execute(Object params){
        for (SignInExecutorUnit unit : signInRuleList) {
            if(unit.execute(params)){
                return;
            }
        }
    }
}
