package com.wangpy.framework.exception;

import com.wangpy.common.core.domain.AjaxResult;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Order(value = 1)
public class RedisException {
    @ExceptionHandler(RedisConnectionFailureException.class)
    public AjaxResult ss(RedisConnectionFailureException e){
        return AjaxResult.error("Redis 连接异常");

    }
}
