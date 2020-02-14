package com.kk.controller;

/*
@author kzj
@date 2019/12/29 - 17:27
*/

import com.kk.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/ajax")
public class AjaxController {

    @RequestMapping("/a1")
    public void ajax(String name, HttpServletResponse response) throws IOException {
        if("admin".equals(name)){
            response.getWriter().print("true");
        }else{
            response.getWriter().print("false");
        }
    }


    @RequestMapping("/a2")
    @ResponseBody
    public List<User> ajax2(){

        List<User> list = new ArrayList<>();
        User user1 = new User("康梓健1", 20, "男");
        User user2 = new User("康梓健2", 20, "男");
        User user3 = new User("康梓健3", 20, "男");
        User user4 = new User("康梓健4", 20, "男");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);

        return list;
    }

    @RequestMapping("/a3")
    @ResponseBody
    public String ajax3(String name, String pwd){
        String msg = "不能为空";
       if(name!=null && name!=""){
           if("admin".equals(name)){
               msg = "ok";
           }else{
               msg = "用户名错误";
           }
       }
       if(pwd!=null && pwd!=""){
            if("123".equals(pwd)){
                msg = "ok";
            }else{
                msg = "密码错误";
            }
       }
       return msg;
    }



}
