package com.crazylemon.yantu.mapper;

import com.crazylemon.yantu.config.RedisConfig;
import com.crazylemon.yantu.entity.Login;
import lombok.AllArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest
@CacheConfig(cacheNames = "login")
public class LoginMapperTest {
    @Autowired
    private LoginMapper loginMapper;
    @Test
    public void testGetByVisitorId(){
        System.out.println(loginMapper.getByVisitorId(1));
    }

    @Test
    @Cacheable
    public void testSave(){
       Login login = loginMapper.getByVisitorId(1);
        System.out.println(login);
        Login login2 =loginMapper.getByVisitorId(1);
        Login login3 =loginMapper.getByVisitorId(1);
    }
}
