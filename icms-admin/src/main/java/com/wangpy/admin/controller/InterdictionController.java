package com.wangpy.admin.controller;

import com.wangpy.common.core.domain.AjaxResult;
import com.wangpy.common.core.redis.RedisCache;
import com.wangpy.common.utils.SecurityUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: wangpy
 * @Description: 封禁控制
 * @Date: Created in 2022/11/3 21:32
 */
@RestController
@RequestMapping(value = "Interdiction")
public class InterdictionController {
    @Resource
    private RedisCache redisCache;

    /**
     * 是否允许当前登录对象登录
     *
     * @return
     */
    @RequestMapping
    public AjaxResult Interdiction() {
        String userId = SecurityUtils.getUserId();
        String key = redisCache.getValByKey(userId).toString();
        if (key != null && !"".equals(key)) {
            return AjaxResult.error();
        }
        return AjaxResult.success();

    }
}
