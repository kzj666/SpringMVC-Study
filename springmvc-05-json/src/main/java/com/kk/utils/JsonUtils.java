package com.kk.utils;

/*
@author kzj
@date 2020/1/23 - 15:54
*/

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;

//返回json数据的工具类
public class JsonUtils {

    public static  String getJson(Object object){
        return getJson(object, "yyyy-MM-dd HH:mm:ss");
    }


    public static String getJson(Object object,String dateFormat) {

        ObjectMapper mapper = new ObjectMapper();

        //设置不使用时间戳的方式
        mapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);
        //自定义日期的格式
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        mapper.setDateFormat(sdf);

        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
