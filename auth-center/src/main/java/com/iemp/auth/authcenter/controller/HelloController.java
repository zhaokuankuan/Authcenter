package com.iemp.auth.authcenter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :Mr.kk
 * @date: 2018/11/29 15:47
 */
@RestController
public class HelloController {


    @GetMapping("/sayHello")
    public String sayHello(){
        return  "Hello shiro!";
    }
}
