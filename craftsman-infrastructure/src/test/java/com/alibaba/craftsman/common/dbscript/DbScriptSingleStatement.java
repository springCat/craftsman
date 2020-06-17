package com.alibaba.craftsman.common.dbscript;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 * @Description DbScriptStatment
 * @Author springCat
 * @Date 2020/6/17 9:18
 */
public class DbScriptSingleStatement extends DbScriptStatement {

    private DbScript dbScript;

    public DbScriptSingleStatement(DbScript dbScript, Statement base, Description description) {
        this.dbScript = dbScript;
        this.base = base;
        this.description = description;
    }

    @Override
    public void evaluate() throws Throwable {
        before(dbScript);
        base.evaluate();
        after(dbScript);

    }
}
