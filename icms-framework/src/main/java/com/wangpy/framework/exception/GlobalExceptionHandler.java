package com.wangpy.framework.exception;

import com.wangpy.common.constant.AjaxResultStatus;
import com.wangpy.common.core.domain.AjaxResult;
import com.wangpy.common.exception.ServiceException;
import com.wangpy.common.exception.user.UserException;
import io.lettuce.core.RedisConnectionException;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

/**
 * @Author: wangpy
 * @Description: 全局异常处理
 * @Date: Created in 2022/8/15 23:03
 */
@RestControllerAdvice
@Order(value = 99)
public class GlobalExceptionHandler {
    /**
     * 用户异常
     * @param e
     * @return
     */
    @ExceptionHandler(UserException.class)
    public AjaxResult userException(UserException e){
        return AjaxResult.error(e.getMessage());

    }

    /**
     * 服务层异常
     * @param e
     * @return
     */
    @ExceptionHandler(ServiceException.class)
    public AjaxResult serviceException(ServiceException e){
        return AjaxResult.error(e.getMessage());

    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public AjaxResult httpRequestMethodNotSupportedException (HttpRequestMethodNotSupportedException e){
       return AjaxResult.ajaxResultStatus(AjaxResultStatus.BAD_METHOD);
        // return new AjaxResult(AjaxResultStatus.BAD_METHOD.getCode(),AjaxResultStatus.BAD_METHOD.getDescribe());

    }

    /**
     *  全局异常捕获
     * @param e
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    public AjaxResult exception(RuntimeException e){
        return AjaxResult.error(e.getClass().toString());

    }


}
