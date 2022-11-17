package com.wangpy.common.exception.user;

import com.wangpy.common.exception.base.BaseException;

/**
 * @Author: wangpy
 * @Description: 用户父级异常
 * @Date: Created in 2022/8/17 23:16
 */
public class UserException extends BaseException {
    public UserException() {
        super();
    }

    public UserException(String message) {
        super(message);
    }

    public UserException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserException(Throwable cause) {
        super(cause);
    }

    protected UserException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
