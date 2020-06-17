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
public class DbScriptBatchStatement extends DbScriptStatement {

   private DbScript[]  dbScripts;

    public DbScriptBatchStatement( DbScripts dbScripts, Statement base, Description description) {
        this.dbScripts = dbScripts.value();
        this.base = base;
        this.description = description;

    }

    @Override
    public void evaluate() throws Throwable {

        for (DbScript dbScript : dbScripts) {
            before(dbScript);
        }

        base.evaluate();

        for (DbScript dbScript : dbScripts) {
            after(dbScript);
        }
    }


}
