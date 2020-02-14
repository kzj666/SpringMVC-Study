package com.kk.config;

/*
@author kzj
@date 2020/1/25 - 17:42
*/

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LoginInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        //放行：判断什么情况放行

        //登录页面也会放行
        if(request.getRequestURI().contains("tologin")){
            return true;
        }

        if(request.getRequestURI().contains("login")){
            return true;
        }

        if(session.getAttribute("username") != null){
            return true;
        }

        //判断什么情况下没有登录
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
        return false;

    }
}
