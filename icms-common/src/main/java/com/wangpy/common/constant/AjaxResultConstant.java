package com.wangpy.common.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Author: wangpy
 * @Description: 响应代码
 * @Date: Created in 2022/8/19 00:12
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum AjaxResultConstant {
    SUCCESS(200,"操作成功");

    private int code;
    private String describe;
}
