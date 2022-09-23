package com.wangpy.admin.controller;

import com.wangpy.common.constant.HttpStatus;
import com.wangpy.common.core.domain.AjaxResult;
import com.wangpy.common.core.domain.entity.SysUserEntity;
import com.wangpy.common.core.domain.model.LoginBody;
import com.wangpy.common.utils.SecurityUtils;
import com.wangpy.framework.web.service.SysLoginService;
import com.wangpy.system.entity.vo.RouterVo;
import com.wangpy.system.entity.vo.UserVo;
import com.wangpy.system.service.SysUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collections;
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

    /**
     * 用户登陆
     *
     * @param loginBody 登录信息
     * @return {@link AjaxResult}
     */
    @PostMapping(value = "login")
    public AjaxResult login(LoginBody loginBody){
        String token = sysLoginService.login(loginBody);
        return AjaxResult.success(HttpStatus.SUCCESS.getDescribe(),token);
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
