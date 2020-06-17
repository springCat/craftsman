package com.alibaba.craftsman.common;

import cn.hutool.core.io.FileUtil;
import com.alibaba.cola.common.ApplicationContextHelper;
import com.alibaba.craftsman.common.dbscript.DbScriptStatement;
import com.alibaba.craftsman.common.dbscript.DbScriptUtil;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.io.File;

/**
 * @Description InitDb
 * @Author springCat
 * @Date 2020/6/16 19:53
 */
@Configuration
public class InitDb {

    @SneakyThrows
    @Bean
    public void initDateSource(){
        //清理上次留下的文件

        File[] files = FileUtil.ls("classpath:dbscript");
        for (File file : files) {
            if(!file.isDirectory()){
                continue;
            }
            String fileName = file.getName();
            DataSource dataSource = (DataSource) ApplicationContextHelper.getBean(fileName);

            FileUtil.del("classpath:target"+File.separator+fileName+".mv.db");
            FileUtil.del("classpath:target"+File.separator+fileName+".trace.db");
            DbScriptUtil.runScript(dataSource,file.getPath()+ File.separator +"init.sql");
        }
    }


}
