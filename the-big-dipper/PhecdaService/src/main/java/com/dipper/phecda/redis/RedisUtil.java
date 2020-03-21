package com.dipper.phecda.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Component
public class RedisUtil {

    private static RedisUtil redisUtil;

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @PostConstruct
    public void init() {
        redisUtil = this;
        redisUtil.redisTemplate = this.redisTemplate;
    }


    /**
     * key是否存在
     *
     * @return
     */
    public static boolean exists(final String key) {
        Boolean execute = redisUtil.redisTemplate.hasKey(key);
        return execute;
    }

    /**
     * value的长度
     *
     * @param key
     * @return
     */
    public static long size(String key) {
        return redisUtil.redisTemplate.opsForValue().size(key);
    }

    /**
     * @param key
     * @param value
     * @return
     */
    public static boolean setIfAbsent(String key, String value) {
        return redisUtil.redisTemplate.opsForValue().setIfAbsent(key, value);
    }

    /**
     * @param key
     * @return
     */
    public static String get(String key) {
        return (String) redisUtil.redisTemplate.opsForValue().get(key);
    }

    /**
     * @param key
     * @return
     */
    public static void set(String key, String value) {
        redisUtil.redisTemplate.opsForValue().set(key, value);
    }

    /**
     * @param key
     * @return
     */
    public static boolean delete(String key) {
        return redisUtil.redisTemplate.delete(key);
    }
}
