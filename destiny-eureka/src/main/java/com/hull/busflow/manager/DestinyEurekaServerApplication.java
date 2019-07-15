package com.hull.busflow.manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 天命系统 eureka服务端
 *
 * @author
 * @create 2018-07-07 下午5:39
 **/

@SpringBootApplication
@EnableEurekaServer
public class DestinyEurekaServerApplication {

    public static Logger logger = LoggerFactory.getLogger(DestinyEurekaServerApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DestinyEurekaServerApplication.class, args);
        logger.info("============================================");
        logger.info("Destiny Eureka Server startup");
        logger.info("============================================");

    }
}
