package com.alibaba.craftsman.domain.signin;

import java.util.List;

/**
 * @Description Reward
 * @Author springCat
 * @Date 2020/6/12 9:59
 */
public abstract class RewardItem {



    public void invoke(){
        if(outLimit() || !given()){
            onfailed();
            return;
        }
        onSuccess();
    }

    public abstract boolean outLimit();

    public abstract boolean given();

    public  void onSuccess(){};

    public abstract void onfailed();

}
