package com.alibaba.craftsman.common;

import com.alibaba.cola.common.ApplicationContextHelper;
import com.alibaba.cola.logger.Logger;
import com.alibaba.cola.logger.LoggerFactory;
import com.alibaba.craftsman.config.DataSourceType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;

/**
 * Spring Boot Starter
 *
 * COLA framework initialization is configured in {@link com.alibaba.craftsman.config.ColaConfig}
 *
 * @author Frank Zhang
 */
@SpringBootApplication(scanBasePackages = {"com.alibaba.craftsman","com.alibaba.cola"})
public class Application {

    private static Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        logger.info("Begin to start Spring Boot Application");
        long startTime = System.currentTimeMillis();
        SpringApplication.run(Application.class, args);
        long endTime = System.currentTimeMillis();
        logger.info("End starting Spring Boot Application, Time used: "+ (endTime - startTime));
    }
}
