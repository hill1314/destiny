package com.hull.busflow.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 前端
 *
 * @author
 * @create 2018-09-15 下午10:22
 **/

@SpringBootApplication
@EnableDiscoveryClient
public class WebApplication {
    public static Logger logger = LoggerFactory.getLogger(WebApplication.class);

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(WebApplication.class, args);

        String[] activeProfiles = context.getEnvironment().getActiveProfiles();
        for (String profile : activeProfiles) {
            logger.info("WebProviderApplication active profile:{}", profile);
        }
        logger.info("==================================");
        logger.info("WebApplication startup");
        logger.info("应用程序启动完毕!");
        logger.info("==================================");

    }
}
