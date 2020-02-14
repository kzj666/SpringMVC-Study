package com.kk.controller;

/*
@author kzj
@date 2020/1/23 - 13:47
*/

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RestFulController {
    @GetMapping("/add/{a}/{b}")
    public String add(@PathVariable int a, @PathVariable int b, Model model){
        int res = a+b;
        Model model1 = model.addAttribute("msg", res);
        return "test";
    }
}
