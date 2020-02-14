package com.kk.utils;

/*
@author kzj
@date 2019/12/28 - 23:17
*/

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.text.SimpleDateFormat;

public class JsonUtils {

    public static String getJson(Object object){
        return getJson(object, "yyyy-MM-dd hh:mm:ss");
    }

    public static String getJson(Object object, String dateFormat){

        ObjectMapper mapper = new ObjectMapper();
        //不返回时间戳,即关闭时间戳
        mapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);
        //时间格式化
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        //让mapper指定时间日期格式为SimpleDateFormat
        mapper.setDateFormat(sdf);

        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

}
