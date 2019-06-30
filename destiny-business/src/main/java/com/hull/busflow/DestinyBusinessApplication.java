package com.hull.busflow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


/**
 * 对外提供的业务接口服务
 *
 * @author
 * @create 2018-07-07 下午7:18
 **/

//@SpringBootApplication
//@EnableDiscoveryClient
//@EnableCircuitBreaker
//@SpringCloudApplication //相当于上面三个
@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
public class DestinyBusinessApplication {

    public static Logger logger = LoggerFactory.getLogger(DestinyBusinessApplication.class);

    public static void main(String[] args) {

        ConfigurableApplicationContext context = SpringApplication.run(DestinyBusinessApplication.class, args);

        String[] activeProfiles = context.getEnvironment().getActiveProfiles();
        for (String profile : activeProfiles) {
            logger.info("DestinyBusinessApplication active profile:{}", profile);
        }
        logger.info("Server startup");
        logger.info("应用程序启动完毕!");
    }

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
