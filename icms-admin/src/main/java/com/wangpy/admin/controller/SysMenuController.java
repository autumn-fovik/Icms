package com.wangpy.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wangpy.common.annotation.Log;
import com.wangpy.common.core.controller.BaseController;
import com.wangpy.common.core.domain.AjaxResult;
import com.wangpy.common.core.domain.entity.SysMenuEntity;
import com.wangpy.common.enums.BusinessType;
import com.wangpy.system.service.SysMenuService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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
     *
     * @return
     */
    @GetMapping(value = "list")
    @PreAuthorize(value = "@ss.hasPermi('system:menu:list')")
    @Log(title = "菜单管理")
    public AjaxResult list() {
        startPage();
        return AjaxResult.success(getDataTable(service.list(new QueryWrapper<SysMenuEntity>().orderByAsc(SysMenuEntity.ORDER_NUM))));


    }

    /**
     * 添加菜单
     *
     * @param sysMenuEntity
     * @return
     */
    @PutMapping(value = "")
    @PreAuthorize(value = "@ss.hasPermi('system:menu:add')")
    @Log(title = "菜单管理", businessType = BusinessType.INSERT)
    public AjaxResult add(@RequestBody SysMenuEntity sysMenuEntity) {
        return AjaxResult.success(service.save(sysMenuEntity));
    }

    /**
     * 更新菜单
     *
     * @param sysMenuEntity
     * @return
     */
    @PostMapping(value = "")
    @PreAuthorize(value = "@ss.hasPermi('system:menu:edit')")
    @Log(title = "菜单管理", businessType = BusinessType.UPDATE)
    public AjaxResult edit(@RequestBody SysMenuEntity sysMenuEntity) {
        return AjaxResult.success(service.updateById(sysMenuEntity));
    }

    /**
     * 获取单个菜单
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    @Log(title = "菜单管理")
    public AjaxResult get(@PathVariable Long id) {
        return AjaxResult.success(service.getById(id));
    }


}
