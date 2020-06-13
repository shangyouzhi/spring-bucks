package com.ibucks.bucks.mongotest;

import com.ibucks.bucks.expression.IException;
import com.ibucks.bucks.model.Coffee;
import com.ibucks.bucks.mongo.service.MongoDataService;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

@SpringBootTest
@Slf4j
public class MongoDataTest {

    @Autowired
    private MongoDataService mongoDataService;

    @Test
    public void testSave(){
        Coffee coffee = Coffee.builder()
                .name("espresso")
                .price(Money.of(CurrencyUnit.of("CNY"),20.1))
                .createTime(new Date(System.currentTimeMillis()))
                .updateTime(new Date(System.currentTimeMillis()))
                .build();
        Coffee result = mongoDataService.save(coffee);
        Assert.notNull(result,"保存失败，结果为null");
    }

    @Test
    public void testFindByName(){
        List<Coffee> coffees =  mongoDataService.findByName("espresso");
        Assert.notEmpty(coffees,"查询结果为空");
        Assert.hasLength(String.valueOf(coffees),"查询结果和预期不符合，预期查询到一条数据，实际查询到："+coffees.size()+"调数据");
    }

    @Test
    public void testUpdateByName() throws IException {
        Coffee coffee = Coffee.builder()
                .name("espresso")
                .price(Money.of(CurrencyUnit.of("CNY"),22.4))
                .build();
        Long count = mongoDataService.updateByName(coffee);
        Assert.isTrue(count == 1,"更新结果和预期不一致，预期更新一条数据，结果更新："+count+" 条数据");

    }

    @Test
    public void testRemoveByName(){
       Long result =  mongoDataService.removeByName("espresso");
       Assert.isTrue(result == 1,"期望删除的数据条数为1，实际删除："+result);
    }
}
