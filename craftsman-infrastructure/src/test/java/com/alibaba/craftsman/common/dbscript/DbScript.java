package com.alibaba.craftsman.common.dbscript;

import com.alibaba.cola.common.ApplicationContextHelper;
import com.alibaba.craftsman.config.DataSourceType;

import javax.sql.DataSource;
import java.lang.annotation.*;

/**
 * @Description dbscript
 * @Author springCat
 * @Date 2020/6/15 17:01
 */
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
@Repeatable(DbScripts.class)
public @interface DbScript {

    DataSourceType databaseName();

    String initSql() default "";

    String cleanSql() default "";

}
