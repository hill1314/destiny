package com.hull;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

/**
 * zipkin 服务
 *
 * @author
 * @create 2019-06-30 09:16
 **/

@EnableZipkinServer
@SpringBootApplication
public class ZipkinServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinServerApplication.class,args);
        System.out.println("ZipkinServer started!");
    }

}
