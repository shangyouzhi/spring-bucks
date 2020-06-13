package com.ibucks.bucks.redis.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ibucks.bucks.model.Coffee;
import com.ibucks.bucks.redis.service.RedisDataService;
import com.ibucks.bucks.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
* @Description:   redis 数据服务提供者
* @Author:         shang
* @CreateDate:     2020/3/26 17:48
* @UpdateUser:     shang
* @UpdateDate:     2020/3/26 17:48
* @UpdateRemark:
* @Version:        1.0
*/
@Service("redisDataService")
public class RedisDataServiceImpl implements RedisDataService {

    @Autowired
    private JedisPool jedisPool;

    @Autowired
    private JsonUtils jsonUtils;

    @Override
    public void hset(Coffee coffee) {
        try(Jedis jedis = jedisPool.getResource()){
         jedis.hset("springbucks-menu","coffee", jsonUtils.objToJson(coffee));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public <T> T hget(String field, Class<T> cl) {
        try(Jedis jedis = jedisPool.getResource()){
           String json =  jedis.hget("springbucks-menu",field);
            try{
                T t =  jsonUtils.fromJson(json,cl);
                return t;
            }catch (Exception se){

                se.printStackTrace();
                se.getMessage();
                return null;
            }
        }
    }
}
