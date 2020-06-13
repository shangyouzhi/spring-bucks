package com.ibucks.bucks.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class JsonUtils {


    @Autowired
    private ObjectMapper objectMapper;


    public String objToJson(Object obj) throws JsonProcessingException {
        return objectMapper.writeValueAsString(obj);
    }

    public <T> T fromJson(String json, Class<T> tClass) throws JsonProcessingException {
        return objectMapper.readValue(json, tClass);
    }

    public <T> List<T> fromJson(String json, Class cla, Class<T> tClass) throws JsonProcessingException {
        JavaType javaType = objectMapper.getTypeFactory().constructCollectionType(cla,tClass);
        return objectMapper.readValue(json,javaType);
    }


    public <K,V> Map<K,V> fromJson(String json,Class cla,Class<K> kClass, Class<V> vClass) throws JsonProcessingException {
        JavaType javaType = objectMapper.getTypeFactory().constructMapLikeType(cla,kClass,vClass);
        return objectMapper.readValue(json,javaType);
    }
}
