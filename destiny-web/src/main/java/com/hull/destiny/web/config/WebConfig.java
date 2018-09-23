package com.hull.destiny.web.config;

import com.hull.destiny.web.interceptor.AuthHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * web 配置
 *
 * @author
 * @create 2018-09-18 上午7:45
 **/

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter{

    //增加拦截器
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new AuthHandlerInterceptor())    //指定拦截器类
                .addPathPatterns("/");        //指定该类拦截的url
    }
}
