package com.kk.controller;

/*
@author kzj
@date 2020/1/23 - 14:34
*/

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EncodingController {
    @PostMapping("/e/t1")
    public String test01(String name , Model model){
        model.addAttribute("msg",name);
        return "test";
    }
}
