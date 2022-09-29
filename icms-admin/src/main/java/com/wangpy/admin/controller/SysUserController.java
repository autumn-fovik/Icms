package com.wangpy.admin.controller;

import com.wangpy.common.controller.BaseController;
import com.wangpy.common.core.domain.AjaxResult;
import com.wangpy.common.core.domain.entity.SysUserEntity;
import com.wangpy.system.service.SysUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: wangpy
 * @Description: 用户访问控制器
 * @Date: Created in 2022/9/28 22:03
 */
@RestController
@RequestMapping(value = "user")
public class SysUserController extends BaseController {
    @Resource
    public SysUserService service;

    @GetMapping(value = "list")
    public AjaxResult list(){
        startPage();
        List<SysUserEntity> list = service.list();
        return AjaxResult.success(getDataTable(list));


    }
}
