package com.hull.busflow.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 首页 登陆
 *
 * @author
 * @create 2018-09-16 上午11:22
 **/


@RestController
@Slf4j
public class IndexController {

    @RequestMapping("/login")
    public String login(String name, String pwd){
        log.info("name={},pwd={}",name,pwd);
        return "success";
    }

    @GetMapping({"/","/index","index.html"})
    public String index(){
        log.info("index");
        return "index";
    }
}
