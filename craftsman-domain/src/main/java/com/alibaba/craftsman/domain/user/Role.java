package com.alibaba.craftsman.domain.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Role Enumeration
 *
 * @author Frank Zhang
 * @date 2018-09-13 12:25 PM
 */
@AllArgsConstructor
public enum Role {
    DEV("开发"),
    QA( "测试"),
    OTHER("非技术岗");

    public String desc;
}
