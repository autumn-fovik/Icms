package com.wangpy.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Author: wangpy
 * @Description: TODO
 * @Date: Created in 2022/10/10 23:05
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum AjaxResultStatus {

    SUCCESS(200,"操作成功"),
    CREATED(201,"对象创建成功"),
    ACCEPTED(202,"请求已经被接受"),
    NO_CONTENT(204,"操作已经执行成功，但是没有返回数据"),
    SMALL_MISTAKE(205,"操作已经执行成功，但是有输入错误"),
    UNAUTHORIZED(401,"未授权）"),
    FORBIDDEN(403,"访问受限，授权过期"),
    NOT_FOUND(404,"资源，服务未找到"),
    BAD_METHOD(405,"不允许的http方法"),
    ERROR(500,"系统错误");

    /**
     * 响应代码
     */
    private int code;

    /**
     * 响应描述
     */
    private String describe;



}
