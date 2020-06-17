package com.alibaba.craftsman.domain.signin;

import java.util.List;

/**
 * @Description Executor
 * @Author springCat
 * @Date 2020/6/12 10:45
 */
public class SignInExecutor {

    private List<SignInExecutorGroup> executorUnits;

    public boolean validate(){return true;}

    public void onStart(){

    }
    public void onEnd(){

    }

    public void execute(Object params){
        //今日已经签到
        if(validate()){
            return;
        }

        onStart();

        for (SignInExecutorGroup executorUnit : executorUnits) {
            executorUnit.execute(params);
        }

        onEnd();
    }
}
