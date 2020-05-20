package com.will.springbootredis;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.hash.Jackson2HashMapper;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.stereotype.Component;

/**
 * @Description springboot-redis的模版测试
 * @Author willfu
 * @Date 2020/5/20 12:00 上午
 * @Version 1.0
 */
@Component
public class TestRedis {
    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

   @Autowired
   ObjectMapper objectMapper;//Java对象与json的映射关系

   @Autowired
   StringRedisTemplate temp;

    public void test(){
//        ValueOperations var = stringRedisTemplate.opsForValue();
//        var.set("name","will");
//        System.out.println(var.get("name"));

        RedisConnection conn = stringRedisTemplate.getConnectionFactory().getConnection();
        conn.set("bookName".getBytes(),"redis".getBytes());
        System.out.println(new String(conn.get("bookName".getBytes())));

        Person person = new Person();
        person.setName("will");
        person.setAge(28);

//        stringRedisTemplate.setHashValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));

        Jackson2HashMapper mapper = new Jackson2HashMapper(objectMapper,false);//json转换HashMap映射器
        temp.opsForHash().putAll("person",mapper.toHash(person));
        System.out.println(temp.opsForHash().entries("person"));
    }
}
