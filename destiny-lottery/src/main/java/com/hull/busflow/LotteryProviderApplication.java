package com.hull.busflow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 抽奖服务提供
 *
 * @author
 * @create 2018-07-07 下午6:56
 **/

@SpringBootApplication
@EnableDiscoveryClient
//@SpringCloudApplication
@EnableHystrix
public class LotteryProviderApplication {

    public static Logger logger = LoggerFactory.getLogger(LotteryProviderApplication.class);

    public static void main(String[] args) {

//        ConfigurableApplicationContext context =
                SpringApplication.run(LotteryProviderApplication.class, args);

//        String[] activeProfiles = context.getEnvironment().getActiveProfiles();
//        for (String profile : activeProfiles) {
//            logger.info("LotteryProviderApplication active profile:{}", profile);
//        }
        logger.info("Server startup");
        logger.info("应用程序启动完毕!");
    }
}
