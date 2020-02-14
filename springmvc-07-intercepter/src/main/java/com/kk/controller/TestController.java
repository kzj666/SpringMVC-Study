package com.kk.controller;

/*
@author kzj
@date 2020/1/25 - 17:10
*/

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/t1")
    public String test(){
        System.out.println("TestController执行了");
        return "OK";

    }
}
