package com.wangpy.admin.controller;

import com.wangpy.common.controller.BaseController;
import com.wangpy.common.core.domain.AjaxResult;
import com.wangpy.common.core.domain.entity.SysMenuEntity;
import com.wangpy.system.service.SysMenuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: wangpy
 * @Description: 菜单访问控制器
 * @Date: Created in 2022/9/27 23:27
 */
@RestController
@RequestMapping(value = "menu")
public class SysMenuController  extends BaseController {
    @Resource
    public SysMenuService service;

    /**
     * 获取全部菜单
     * @return
     */
    @GetMapping(value = "list")
    public AjaxResult list(){
        startPage();
        List<SysMenuEntity> list = service.list();
        return AjaxResult.success(getDataTable(list));
    }

    /**
     * 获取全部菜单（树形）
     * @return
     */
    public AjaxResult listTree(){
        return null;
    }

}
