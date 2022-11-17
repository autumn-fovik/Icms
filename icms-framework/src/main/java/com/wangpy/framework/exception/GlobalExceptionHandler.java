package com.wangpy.framework.exception;

import com.wangpy.common.constant.AjaxResultStatus;
import com.wangpy.common.core.domain.AjaxResult;
import com.wangpy.common.exception.ServiceException;
import com.wangpy.common.exception.base.BaseException;
import com.wangpy.common.exception.user.UserException;
import org.mybatis.spring.MyBatisSystemException;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.RedisConnectionFailureException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

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
     *
     * @param e
     * @return
     */
    @ExceptionHandler(ServiceException.class)
    public AjaxResult serviceException(ServiceException e) {
        return AjaxResult.error(e.getMessage());

    }

    /**
     * 权限校验异常
     */
    @ExceptionHandler(AccessDeniedException.class)
    public AjaxResult handleAccessDeniedException(AccessDeniedException e, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        //log.error("请求地址'{}',权限校验失败'{}'", requestURI, e.getMessage());
        return AjaxResult.ajaxResultStatus(AjaxResultStatus.INSUFFICIENT_PRIVILEGES, "没有权限，请联系管理员授权");
    }

    /**
     * Redis 链接异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(RedisConnectionFailureException.class)
    public AjaxResult ss(RedisConnectionFailureException e) {
        return AjaxResult.error("Redis 连接异常");

    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public AjaxResult httpRequestMethodNotSupportedException (HttpRequestMethodNotSupportedException e){
       return AjaxResult.ajaxResultStatus(AjaxResultStatus.METHOD_NOT_ALLOW);
        // return new AjaxResult(AjaxResultStatus.BAD_METHOD.getCode(),AjaxResultStatus.BAD_METHOD.getDescribe());

    }

    @ExceptionHandler(MyBatisSystemException.class)
    public AjaxResult myBatisSystemException(MyBatisSystemException e) {
        return AjaxResult.error("Mysql 连接异常");
    }

    /**
     * 全局异常捕获
     *
     * @param e
     * @return
     */
    @ExceptionHandler(BaseException.class)
    public AjaxResult exception(BaseException e) {
        e.printStackTrace();
        return AjaxResult.error(e.getClass().toString());

    }


}
