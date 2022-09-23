package com.wangpy.common.exception.user;

/**
 * @Author: wangpy
 * @Description: TODO
 * @Date: Created in 2022/8/17 23:16
 */
public class UserPasswordNotMatchException extends UserException{
    public UserPasswordNotMatchException() {
        super();
    }

    public UserPasswordNotMatchException(String message) {
        super(message);
    }

    public UserPasswordNotMatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserPasswordNotMatchException(Throwable cause) {
        super(cause);
    }

    protected UserPasswordNotMatchException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
