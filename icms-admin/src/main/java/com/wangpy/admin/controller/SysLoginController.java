package com.wangpy.admin.controller;

import com.wangpy.common.constant.AjaxResultStatus;
import com.wangpy.common.constant.Constants;
import com.wangpy.common.constant.HttpStatus;
import com.wangpy.common.core.domain.AjaxResult;
import com.wangpy.common.core.domain.entity.SysUserEntity;
import com.wangpy.common.core.domain.model.LoginBody;
import com.wangpy.common.core.redis.RedisCache;
import com.wangpy.common.utils.SecurityUtils;
import com.wangpy.framework.web.service.SysLoginService;
import com.wangpy.system.entity.vo.RouterVo;
import com.wangpy.system.entity.vo.UserVo;
import com.wangpy.system.service.SysUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: wangpy
 * @Description: 登陆控制类
 * @Date: Created in 2022/8/9 19:13
 */

@RestController
@RequestMapping(value = "auth")
public class SysLoginController {

    @Resource
    private SysLoginService sysLoginService;
    @Resource
    private SysUserService userService;
    @Autowired
    private RedisCache redisCache;


    /**
     * 用户登陆
     *
     * @param loginBody 登录信息
     * @return {@link AjaxResult}
     */
    @PostMapping(value = "login")
    public AjaxResult login(@RequestBody LoginBody loginBody) {

        if (loginBody.getUuid().equals("") || loginBody.getCaptcha().equals(""))
            return AjaxResult.ajaxResultStatus(AjaxResultStatus.SMALL_MISTAKE, "验证码不能为空");
        Object str = redisCache.getValByKey(Constants.CAPTCHA_CODE_KEY + loginBody.getUuid());
        if (str == null) {
            return AjaxResult.ajaxResultStatus(AjaxResultStatus.NO_CONTENT, "验证码过期");
        }
        String valByKey = str.toString();
        if (valByKey.equalsIgnoreCase(loginBody.getCaptcha())) {
            String token = sysLoginService.login(loginBody);
            return AjaxResult.success(HttpStatus.SUCCESS.getDescribe(), token);
        } else {
            return AjaxResult.ajaxResultStatus(AjaxResultStatus.NO_CONTENT, "验证码错误");
        }

    }

    /**
     * 获取用户信息
     *
     * @return {@link AjaxResult}
     */
    @GetMapping(value = "getUserInfo")
    public AjaxResult getUserInfo(){
        SysUserEntity userInfo = sysLoginService.getUserInfo();
        UserVo vo = new UserVo();
        BeanUtils.copyProperties(userInfo,vo);
       List<String>  permission =  userService.queryUserPermission(SecurityUtils.getUserId());
        vo.setPermissions(permission);
        return  AjaxResult.success(vo);

    }

    /**
     * 获取路由
     *
     * @return {@link AjaxResult}
     */
    @GetMapping(value = "getRoute")
    public AjaxResult getRoute(){
        List<RouterVo> route = sysLoginService.getRoute();
        return AjaxResult.success(route);

    }
}
