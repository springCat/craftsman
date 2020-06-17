package com.alibaba.craftsman.common.dbscript;

import cn.hutool.core.io.FileUtil;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;
import org.h2.tools.RunScript;
import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @Description dbscript
 * @Author springCat
 * @Date 2020/6/15 17:01
 */

@UtilityClass
public class DbScriptUtil {

    @SneakyThrows
    public void runScript(DataSource dataSource, String filePath){
        Connection connection = dataSource.getConnection();
        RunScript.execute(connection, FileUtil.getReader(filePath, "UTF-8"));
        connection.commit();
    }

}
