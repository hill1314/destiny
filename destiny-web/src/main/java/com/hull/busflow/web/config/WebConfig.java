package com.hull.busflow.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * web 配置
 *
 * @author
 * @create 2018-09-18 上午7:45
 **/

@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter{

    private static final String[] RESOURCE_LOCATIONS = {"classpath:/resources/", "classpath:/static/"};


    private static final String[] LOGIN_EXCLUED_LOCATIONS = {
            "classpath:/static/",
            "/",
            "/health",
            "/monitor/druid/**",
            "/storm/**",
            "/druid/**",
            "/bill/sync/**",
            "/bill/syncCal/**",
            "/bill/salary/**",
            "/downloadExcel",
            "/login",
            "/logout",
            "/alive",
            "/error",
            "/404",
            "/403",
            "/500"};


    //增加拦截器
    public void addInterceptors(InterceptorRegistry registry){
//        registry.addInterceptor(new AuthHandlerInterceptor())    //指定拦截器类
//                .addPathPatterns("/");        //指定该类拦截的url
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        if (!registry.hasMappingForPattern("/**")) {
            registry.addResourceHandler("/**").addResourceLocations(RESOURCE_LOCATIONS);
        }
    }


    //fix springmvc ajax encoding bug
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.extendMessageConverters(converters);
        List<HttpMessageConverter<?>> myConverters = new ArrayList<HttpMessageConverter<?>>();
        for (HttpMessageConverter<?> c : converters) {
            if (c instanceof StringHttpMessageConverter) {
                c = new StringHttpMessageConverter(Charset.forName("UTF-8"));
            }
            myConverters.add(c);
        }
        converters.clear();
        converters.addAll(myConverters);
    }
}
