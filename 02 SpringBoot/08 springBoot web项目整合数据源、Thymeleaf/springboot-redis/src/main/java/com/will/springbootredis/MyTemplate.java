package com.will.springbootredis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

/**
 * @Description TODO
 * @Author willfu
 * @Date 2020/5/20 8:42 上午
 * @Version 1.0
 */
@Configuration
public class MyTemplate {

    @Bean
    public StringRedisTemplate temp(RedisConnectionFactory fc){
        StringRedisTemplate temp = new StringRedisTemplate();
        temp.setConnectionFactory(fc);
        temp.setHashValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
        return temp;
    }
}
