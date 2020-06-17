package com.alibaba.craftsman.common.dbscript;

import cn.hutool.core.io.FileUtil;
import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.alibaba.cola.common.ApplicationContextHelper;
import lombok.SneakyThrows;
import org.h2.tools.RunScript;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @Description DbScriptStatment
 * @Author springCat
 * @Date 2020/6/17 9:18
 */
public abstract class DbScriptStatement extends Statement {

    private Log log = LogFactory.get();

    protected Statement base;

    protected Description description;

    public void before(DbScript dbScript){
        execute(dbScript.databaseName().name(),dbScript.initSql());
    }

    public void after(DbScript dbScript){
        execute(dbScript.databaseName().name(),dbScript.cleanSql());
    }

    private void execute(String databaseName,String path){
        if(!path.isEmpty()){
            DataSource dataSource = (DataSource) ApplicationContextHelper.getBean(databaseName);
            path = "classpath:dbscript/"+databaseName+"/"+path;
            DbScriptUtil.runScript(dataSource,path);
            log.info("dbScriptStatement :{},execute sql {} ",databaseName,path);
        }
    }



}
