package com.kk.controller;

/*
@author kzj
@date 2020/1/23 - 12:18
*/

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController implements Controller {


    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        ModelAndView mv = new ModelAndView();

        //业务代码
        String result = "HelloSpringMVC";
        mv.addObject("msg",result);
        //视图跳转
        mv.setViewName("test");

        return mv;
    }
}
