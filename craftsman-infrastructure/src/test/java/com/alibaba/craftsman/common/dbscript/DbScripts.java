package com.alibaba.craftsman.common.dbscript;

import java.lang.annotation.*;

/**
 * @Description DbScriptList
 * @Author springCat
 * @Date 2020/6/17 11:50
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface DbScripts {

    DbScript[] value();
}
