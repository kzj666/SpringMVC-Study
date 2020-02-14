package com.kk.controller;

/*
@author kzj
@date 2020/1/23 - 15:20
*/

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kk.pojp.User;
import com.kk.utils.JsonUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;


//@Controller
@RestController//该注解标注的类下全部不经过视图解析器，直接返回字符串
public class UserController {

    @RequestMapping("/j1")
    public String json() throws JsonProcessingException {

        User user = new User("康梓健",18,"男");

        ObjectMapper mapper = new ObjectMapper();
        String str = mapper.writeValueAsString(user);

        return str;
    }


    @RequestMapping("/j2")
    public String json2() {

        ArrayList<User> users = new ArrayList<User>();

        User user1 = new User("康梓健1",18,"男");
        User user2 = new User("康梓健2",18,"男");
        User user3 = new User("康梓健3",18,"男");
        User user4 = new User("康梓健4",18,"男");

        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        return JsonUtils.getJson(users);

    }


    @RequestMapping("/j3")
    public String json3() {
        Date date = new Date();
        return JsonUtils.getJson(date);
    }


    @RequestMapping("/j4")
    public String json4(){
        ArrayList<User> useList = new ArrayList<User>();
        User user1 = new User("康梓健1",18,"男");
        User user2 = new User("康梓健2",18,"男");
        User user3 = new User("康梓健3",18,"男");
        User user4 = new User("康梓健4",18,"男");
        useList.add(user1);
        useList.add(user2);
        useList.add(user3);
        useList.add(user4);
        String str  = JSON.toJSONString(useList);
        return str ;
    }


}
