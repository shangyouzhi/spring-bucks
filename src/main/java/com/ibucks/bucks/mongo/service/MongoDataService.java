package com.ibucks.bucks.mongo.service;

import com.ibucks.bucks.expression.IException;
import com.ibucks.bucks.model.Coffee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MongoDataService {

    /**
     * 添加实体
     * @param coffee
     */
    Coffee save(Coffee coffee);

    /**
     * 根据条件查询实体
     * @param name
     * @return
     */
    List<Coffee> findByName(String name);

    /**
     * 通过名字更新
     * @param coffee
     * @throws IException
     */
    Long updateByName(Coffee coffee) throws IException;

    /**
     * 通过名称remove
     * @param name
     */
    Long removeByName(String name);

}
