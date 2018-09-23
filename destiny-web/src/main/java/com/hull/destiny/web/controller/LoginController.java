package com.hull.destiny.web.controller;

import lombok.extern.slf4j.Slf4j;
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
@RequestMapping("/home")
public class LoginController {

    @RequestMapping("/login")
    public String login(String name, String pwd){
        log.info("name={},pwd={}",name,pwd);
        return "success";
    }
}
