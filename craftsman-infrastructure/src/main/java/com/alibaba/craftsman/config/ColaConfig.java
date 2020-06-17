package com.alibaba.craftsman.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.cola.boot.Bootstrap;
import org.springframework.context.annotation.ImportResource;

import java.util.ArrayList;
import java.util.List;

/**
 * Configuration for COLA framework
 */
@ImportResource(locations = {"classpath:datasource/craftsman.xml","classpath:datasource/craftsman1.xml"})
@Configuration
public class ColaConfig {

    @Bean(initMethod = "init")
    public Bootstrap bootstrap() {
        Bootstrap bootstrap = new Bootstrap();
        List<String> packagesToScan  = new ArrayList<>();
        packagesToScan.add("com.alibaba.craftsman");
        bootstrap.setPackages(packagesToScan);
        return bootstrap;
    }

}