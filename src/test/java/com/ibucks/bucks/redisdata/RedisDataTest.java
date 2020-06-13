package com.ibucks.bucks.redisdata;

import com.ibucks.bucks.model.Coffee;
import com.ibucks.bucks.redis.service.RedisDataService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
@Slf4j
public class RedisDataTest {

    @Autowired
    private RedisDataService redisDataService;

    @Test
    public void testHset(){
        Coffee coffee = Coffee.builder()
                .id("111")
                .name("latte")
                .price(Money.of(CurrencyUnit.of("CNY"),22.3))
                .createTime(new Date(System.currentTimeMillis()))
                .updateTime(new Date(System.currentTimeMillis())).build();
        redisDataService.hset(coffee);
    }

    @Test
    public void testHget(){
       Coffee result =  redisDataService.hget("coffee",Coffee.class);
       log.info("查询结果：{}",result);
    }
}
