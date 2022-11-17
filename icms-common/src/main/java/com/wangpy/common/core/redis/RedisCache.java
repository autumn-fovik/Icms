package com.wangpy.common.core.redis;

import com.alibaba.fastjson2.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Author: wangpy
 * @Description: Redis 缓存操作类
 * @Date: Created in 2022/9/21 16:26
 */
@Component
public class RedisCache {
    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 存储
     * @param key 键
     * @param val 值
     */
    public void setKeyAdnVal(String key , Object val){
        redisTemplate.opsForValue().set(key, JSON.toJSONString(val));
    }

    /**
     * 存储（设置过期时间）
     * @param key 键
     * @param val 值
     * @param time 过期时间
     * @param timeUnit 过期时间单位
     */
    public void setKeyAndVal(String key, Object val, Integer time, TimeUnit timeUnit){
        redisTemplate.opsForValue().set(key, JSON.toJSONString(val),time,timeUnit);

    }

    /**
     * 获取值
     *
     * @param key 键
     * @return 值
     */
    public Object getValByKey(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 存储
     *
     * @param key
     * @param val
     */
    public void setKeyAndValString(String key, String val) {
        redisTemplate.opsForValue().set(key, val);

    }

    /**
     * 存储
     *
     * @param key
     * @param val
     * @param time
     * @param timeUnit
     */
    public void setKeyAndValString(String key, String val, Integer time, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, val, time, timeUnit);

    }
}
