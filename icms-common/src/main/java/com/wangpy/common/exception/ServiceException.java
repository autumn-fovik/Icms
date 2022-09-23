package com.wangpy.common.exception;

import com.wangpy.common.exception.base.BaseException;

/**
 * @Author: wangpy
 * @Description: 业务层异常
 * @Date: Created in 2022/8/17 23:13
 */
public class ServiceException extends BaseException {
    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    protected ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
