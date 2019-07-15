package com.hull;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 *
 *
 * @author
 * @create 2019-06-30 11:39
 **/


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
public class DispatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(DispatchApplication.class,args);
        System.out.println("Dispatch server started!");
    }

}
