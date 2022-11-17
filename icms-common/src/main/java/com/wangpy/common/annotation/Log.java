package com.wangpy.common.annotation;

import com.wangpy.common.enums.BusinessType;

import java.lang.annotation.*;

/**
 * @Author: wangpy
 * @Description: 自定义日志注解
 * @Date: Created in 2022/11/8 22:55
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    /**
     * 模块
     */
    public String title() default "";

    /**
     * 功能
     */
    public BusinessType businessType() default BusinessType.OTHER;
//
//    /**
//     * 操作人类别
//     */
//    public OperatorType operatorType() default OperatorType.MANAGE;

    /**
     * 是否保存请求的参数
     */
    public boolean isSaveRequestData() default true;

    /**
     * 是否保存响应的参数
     */
    public boolean isSaveResponseData() default true;
}