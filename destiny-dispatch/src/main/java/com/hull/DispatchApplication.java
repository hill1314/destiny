package com.hull;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 *
 *
 * @author
 * @create 2019-06-30 11:39
 **/


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class DispatchApplication {

    public static void main(String[] args) {
        SpringApplication.run(DispatchApplication.class,args);
        System.out.println("Dispatch server started!");
    }

}
