package com.ibucks.bucks.redis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
* @Description:   jedi连接池配置类
* @Author:         shang
* @CreateDate:     2020/3/26 17:36
* @UpdateUser:     shang
* @UpdateDate:     2020/3/26 17:36
* @UpdateRemark:
* @Version:        1.0
*/
@ConfigurationProperties(value = "redis")
@Component
public class JedisPoolConfiguration {

    private String host;
    private Integer maxTotal;
    private Integer minIdle;
    private Boolean testOnBorrow;

    @Bean(destroyMethod = "close")
    public JedisPool initPoll(@Value("${redis.host}")String host){
        return new JedisPool(new JedisPoolConfig(),host);
    }
}
