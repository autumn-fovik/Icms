package com.wangpy.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Author: wangpy
 * @Description: 响应状态 描述
 * @Date: Created in 2022/11/3 23:53
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum AjaxResultStatus {

    /**
     * 2 ** 正常代码
     * 3 ** 不被支持的操作
     * 4 ** 权限相关
     * 5 ** 服务内部错误
     */

    SUCCESS(200, "操作成功"),
    CREATED(201, "对象创建成功"),
    ACCEPTED(202, "请求已经被接受"),
    NO_CONTENT(204, "操作已经执行成功，但是没有返回数据"),
    SMALL_MISTAKE(205, "参数错误"),
    NORMAL_EXECUTION_WITH_ERROR(210, "操作正常执行，但发生错误"),


    METHOD_NOT_ALLOW(300, "不备允许的HTTP方法"),

    UNAUTHORIZED(400, "未授权"),

    INSUFFICIENT_PRIVILEGES(401, "权限不足"),

    ERROR(500, "系统错误");


    /**
     * 响应代码
     */
    private int code;
    /**
     * 默认描述信息
     */
    private String information;

}
