package com.ibucks.bucks.sevice;

import com.ibucks.bucks.model.usermodel.User;

public interface UserService {

    /**
     * 通过主键查询
     * @param userId
     * @return
     */
    User getUserByPrimaryKey(Integer userId);

}
