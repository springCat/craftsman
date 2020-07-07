package com.alibaba.craftsman.domain.signin;

import java.util.List;

/**
 * @Description Reward
 * @Author springCat
 * @Date 2020/6/12 9:59
 */
public abstract class Reward {

    private List<RewardItem> rewardList;

    public void invoke(){
        for (RewardItem rewardItem : rewardList) {
            rewardItem.invoke();
        }
    }
}
