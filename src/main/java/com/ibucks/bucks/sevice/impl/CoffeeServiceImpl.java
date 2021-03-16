package com.ibucks.bucks.sevice.impl;

import com.ibucks.bucks.model.mapper.CoffeeMapper;
import com.ibucks.bucks.model.usermodel.CoffeeExample;
import com.ibucks.bucks.sevice.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("coffeeService")
public class CoffeeServiceImpl implements CoffeeService {

    @Autowired
    private CoffeeMapper coffeeMapper;
    @Override
    public Long countCoffee() {
        CoffeeExample example = new CoffeeExample();
        return coffeeMapper.countByExample(example);
    }
}
