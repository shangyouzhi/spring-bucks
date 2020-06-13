package com.ibucks.bucks.sevice.impl;

import com.ibucks.bucks.model.mapper.UserMapper;
import com.ibucks.bucks.model.usermodel.User;
import com.ibucks.bucks.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @Description:   用户服务提供者
* @Author:         shang
* @CreateDate:     2020/4/11 14:58
* @UpdateUser:     shang
* @UpdateDate:     2020/4/11 14:58
* @UpdateRemark:
* @Version:        1.0
*/
@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User getUserByPrimaryKey(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }
}
