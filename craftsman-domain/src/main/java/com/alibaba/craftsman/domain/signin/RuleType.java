package com.alibaba.craftsman.domain.signin;

import lombok.AllArgsConstructor;

/**
 * @Description RuleType
 * @Author springCat
 * @Date 2020/6/12 9:24
 */

@AllArgsConstructor
public enum RuleType {

    FORECVER(1),
    FIXED(2),
    CHOOSE(3),
    ;

   private int type;

}
