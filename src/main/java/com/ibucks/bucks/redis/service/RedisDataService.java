package com.ibucks.bucks.redis.service;

import com.ibucks.bucks.model.Coffee;

public interface RedisDataService {

    /**
     * set
     * @param coffee
     */
    void hset(Coffee coffee);


     <T> T hget(String field,Class<T> cl);
}
