package com.wangpy.admin.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: wangpy
 * @Description: 首页默认地址
 * @Date: Created in 2022/8/19 22:55
 */
@RestController
public class SysIndexController {
    /**
     * 默认欢迎页
     *
     * @return {@link String}
     */
    @RequestMapping(value = "/")
    public String index(){
        return "欢迎使用Icms后台管理框架，当前版本：v1.0.0，请通过前端地址访问。";
    }
}
