package com.ibucks.bucks.beans;

import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import java.util.List;

/**
* @Description:   扩展springboot自动装配 MongoCustomConversion类
* @Author:         shang
* @CreateDate:     2020/3/26 16:29
* @UpdateUser:     shang
* @UpdateDate:     2020/3/26 16:29
* @UpdateRemark:
* @Version:        1.0
*/
public class IMongoCustomConversions extends MongoCustomConversions {

    public IMongoCustomConversions(List<?> converters) {
        super(converters);
    }

}
