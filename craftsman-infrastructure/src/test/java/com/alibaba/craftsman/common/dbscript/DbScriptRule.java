package com.alibaba.craftsman.common.dbscript;

import cn.hutool.core.io.FileUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import lombok.SneakyThrows;
import org.h2.tools.RunScript;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @Description BaseTest
 * @Author springCat
 * @Date 2020/6/15 17:21
 */
public class DbScriptRule implements TestRule {

    @Override
    public Statement apply(Statement statement, Description description) {
        DbScripts dbScripts = description.getAnnotation(DbScripts.class);
        if(dbScripts != null) {
            return new DbScriptBatchStatement(dbScripts, statement, description);
        }

        DbScript dbScript = description.getAnnotation(DbScript.class);
        if(dbScript != null) {
            return new DbScriptSingleStatement(dbScript, statement, description);
        }
        return statement;
    }


}
