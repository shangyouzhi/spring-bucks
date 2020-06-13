package com.ibucks.bucks.user;

import com.ibucks.bucks.model.usermodel.User;
import com.ibucks.bucks.sevice.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;
    @Test
    public void testGetUserByPrimaryKey(){
       User user =  userService.getUserByPrimaryKey(1);
        Assert.notNull(user,"查询错误");
        System.out.println(user.toString());
    }
}
