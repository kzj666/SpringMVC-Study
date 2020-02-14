package com.kk.controller;

/*
@author kzj
@date 2019/12/28 - 16:22
*/


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.kk.pojo.User;
import com.kk.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {


    /*
        核心总结；将对象转化为json字符串，核心方法是：new ObjectMapper().writeValueAsString(object)
        还有Date的格式化问题，已将处理方法封装到JsonUtils类中的getJson方法
    */


    @ResponseBody
    @RequestMapping("/json1")
    public String json1() throws JsonProcessingException {
        //需要一个jackson对象映射器，就是ObjectMapper类，使用它可以直接将对象转换为json字符串
        ObjectMapper mapper = new ObjectMapper();

        //创建一个user对象
        User user = new User("康梓健", 1, "男");
        System.out.println(user);

        //将java对象转化为json字符串
        String str = mapper.writeValueAsString(user);
        System.out.println(str);

        return str;
    }


    //发现ResponseBody返回的数据出现乱码
    //解决法1：通过@RequestMapping的produces属性来实现---设置一下编码格式为utf-8，以及它返回的类型
    @ResponseBody
    @RequestMapping(value = "/json2", produces = "application/json;charset=utf-8")
    public String json2() throws JsonProcessingException {

        User user = new User("康梓健", 20, "男");
        return new ObjectMapper().writeValueAsString(user);
    }

    //解决法2，在springmvc.xml文件中的<mvc:annotation-driven>标签内添加代码。

    @ResponseBody
    @RequestMapping(value = "/json3")
    public String json3() throws JsonProcessingException {

        List<User> list = new ArrayList<>();
        User user1 = new User("康梓健1", 20, "男");
        User user2 = new User("康梓健2", 20, "男");
        User user3 = new User("康梓健3", 20, "男");
        User user4 = new User("康梓健4", 20, "男");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        return new ObjectMapper().writeValueAsString(list);
    }

    @ResponseBody
    @RequestMapping(value = "/time1")
    public String json4() throws JsonProcessingException {
        Date date = new Date();
        System.out.println(date);
        //发现问题，时间默认返回的json字符串变成了时间戳的格式(Timestamp)
        return new ObjectMapper().writeValueAsString(date);
    }


    @ResponseBody
    @RequestMapping(value = "/time2")
    public String json5() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        //不返回时间戳,即关闭时间戳
        mapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);
        //时间格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //让mapper指定时间日期格式为SimpleDateFormat
        mapper.setDateFormat(sdf);

        //写一个日期对象
        Date date = new Date();

        return mapper.writeValueAsString(date);
    }



    //将上方法封装，直接调用方法
    @ResponseBody
    @RequestMapping(value = "/time3")
    public String json6() throws JsonProcessingException {

        return JsonUtils.getJson(new Date());
    }



}
