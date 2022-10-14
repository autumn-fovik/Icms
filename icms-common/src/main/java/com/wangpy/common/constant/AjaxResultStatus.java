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
