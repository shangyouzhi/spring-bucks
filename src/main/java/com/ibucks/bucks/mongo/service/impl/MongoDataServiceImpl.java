package com.ibucks.bucks.mongo.service.impl;

import com.ibucks.bucks.expression.IException;
import com.ibucks.bucks.model.Coffee;
import com.ibucks.bucks.mongo.service.MongoDataService;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
/**
* @Description:   MongoDB服务提供者
* @Author:         shang
* @CreateDate:     2020/3/26 15:07
* @UpdateUser:     shang
* @UpdateDate:     2020/3/26 15:07
* @UpdateRemark:
* @Version:        1.0
*/
@Service("mongoDataService")
@Slf4j
public class MongoDataServiceImpl implements MongoDataService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Coffee save(Coffee coffee) {
        Coffee saved = mongoTemplate.save(coffee);
        log.info("添加数据到MongoDB成功：{}",saved);
        return saved;
    }

    @Override
    public List<Coffee> findByName(String name) {
       List<Coffee> coffess =  mongoTemplate.find(Query.query(Criteria.where("name").is(name)),Coffee.class);
       log.info("查询结果为：{}",coffess);
       return coffess;
    }

    @Override
    public Long updateByName(Coffee coffee) throws IException {
        if(null == coffee){
            throw new IException("【mongo更新数据】","待更新实体不能为空");
        }
        Update update = new Update();
        if(null != coffee.getPrice()){
            update.set("price", coffee.getPrice());
        }
        update.currentDate("updateTime");
        UpdateResult updateResult = mongoTemplate.updateFirst(Query.query(Criteria.where("name").is(coffee.getName())),update,Coffee.class);
        log.info("更新结果：{}",updateResult);
        return updateResult.getModifiedCount();
    }

    @Override
    public Long removeByName(String name) {
        DeleteResult result = mongoTemplate.remove(Query.query(Criteria.where("name").is(name)),"coffee");
        log.info("删除结果：{}",result);
        return result.getDeletedCount();
    }
}
