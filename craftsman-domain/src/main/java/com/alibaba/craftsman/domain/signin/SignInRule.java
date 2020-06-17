package com.alibaba.craftsman.domain.signin;

import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Description IRule
 * @Author springCat
 * @Date 2020/6/12 9:16
 */
@Data
public class SignInRule {

    private int id;

    private String name;

    private LocalDateTime validStartTime;

    private LocalDateTime validEndTime;

    private int signCount;

    //1,2,3   if pool 活跃,沉默   ,测试
    private Reward reward;

    public boolean isAlreadySignIn(String identityId,int ruleId){
        return false;
    }

    public int getUserSignInCount(String identityId,LocalDateTime signStartTime,LocalDateTime signEndTime){
        return 0;
    }

    public boolean invoke(String identityId,LocalDateTime signDate){

        //is alreadySignIn
        boolean alreadySignIn = isAlreadySignIn(identityId, id);
        if(alreadySignIn){
            return false;
        }

        //get user signCount from
        int userSignInCount = getUserSignInCount(identityId, validStartTime, validEndTime);
        if(userSignInCount >= signCount){
            return false;
        }

        //下发奖励

        reward.invoke();

        return true;
    }
}
