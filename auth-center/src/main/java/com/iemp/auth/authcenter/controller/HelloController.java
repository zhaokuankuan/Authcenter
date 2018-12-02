package com.iemp.auth.authcenter.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :Mr.kk
 * @date: 2018/11/29 15:47
 */
@RestController
@Api(tags = {"hello-controller"},description = "测试controller")
public class HelloController {


    @GetMapping("/sayHello")
    public String sayHello(){
        return  "Hello shiro!";
    }
}
