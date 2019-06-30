package com.hull.busflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 *
 *
 * @author
 * @create 2018-07-11 下午10:36
 **/
@EnableZuulProxy
@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableFeignClients
//@ComponentScan(basePackages = {"com.hull.destiny"})
public class DestinyGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(DestinyGatewayApplication.class, args);
//        new SpringApplicationBuilder(DestinyGatewayApplication.class).web(true).run(args);
        System.out.println("GatewayApp start up!");
    }
}
