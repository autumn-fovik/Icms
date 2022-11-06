package com.wangpy.admin.controller;

import com.wangpy.common.core.domain.AjaxResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wangpy
 * @Description: 封禁控制
 * @Date: Created in 2022/11/3 21:32
 */
@RestController
@RequestMapping(value = "Interdiction")
public class InterdictionController {
    /**
     * 是否允许当前登录对象登录
     *
     * @return
     */
    @RequestMapping
    public AjaxResult Interdiction() {
        return AjaxResult.success();

    }
}
