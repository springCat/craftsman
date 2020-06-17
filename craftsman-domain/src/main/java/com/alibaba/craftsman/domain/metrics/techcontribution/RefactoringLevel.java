package com.alibaba.craftsman.domain.metrics.techcontribution;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * RefactoringLevel
 *
 * @author Frank Zhang
 * @date 2018-09-20 3:37 PM
 */
@AllArgsConstructor
public enum RefactoringLevel {

    METHOD(2, "方法级别的重构"),
    MODULE( 4, "模块级别的重构（多个方法和类的重构）"),
    PROJECT(10, "项目级别的重构（超过3个人日的重构项目）");


    @Getter
    private double score;

    private String desc;

}
