package com.wangpy.admin.controller;

import com.wangpy.common.annotation.Log;
import com.wangpy.common.core.controller.BaseController;
import com.wangpy.common.core.domain.AjaxResult;
import com.wangpy.common.core.domain.entity.SysRoleEntity;
import com.wangpy.common.core.domain.entity.SysRoleMenuEntity;
import com.wangpy.common.enums.BusinessType;
import com.wangpy.common.utils.SecurityUtils;
import com.wangpy.system.service.SysRoleMenuService;
import com.wangpy.system.service.SysRoleService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wangpy
 * @Description: 角色访问控制类
 * @Date: Created in 2022/10/20 15:32
 */
@RestController
@RequestMapping("role")
public class SysRoleController extends BaseController {
    @Resource
    private SysRoleService service;
    @Resource
    private SysRoleMenuService roleMenuService;

    /**
     * 获取角色列表
     *
     * @return
     */
    @GetMapping(value = "list")
    @PreAuthorize(value = "@ss.hasPermi('system:role:list')")
    @Log(title = "角色管理")
    public AjaxResult list() {
        startPage();
        return AjaxResult.success(getDataTable(service.list()));
    }

    /**
     * 新增角色
     *
     * @param role
     * @return
     */

    @PutMapping(value = "")
    @PreAuthorize(value = "@ss.hasPermi('system:role:add')")
    @Log(title = "角色管理", businessType = BusinessType.INSERT)
    public AjaxResult add(@RequestBody SysRoleEntity role) {
        role.setCreateBy(SecurityUtils.getUserId().toString());
        boolean save = service.save(role);
        List<SysRoleMenuEntity> userRoleEntities = new ArrayList<>();
        for (Long roleId : role.getMenuIds()) {
            SysRoleMenuEntity roleMenuEntity = new SysRoleMenuEntity();
            roleMenuEntity.setRoleId(role.getRoleId());
            roleMenuEntity.setMenuId(roleId);
            userRoleEntities.add(roleMenuEntity);
        }
        boolean saveBatch = roleMenuService.saveBatch(userRoleEntities);
        return save ? AjaxResult.success("OK") : AjaxResult.error();
    }

    /**
     * 更新角色
     *
     * @param role
     * @return
     */
    @PostMapping(value = "")
    @PreAuthorize(value = "@ss.hasPermi('system:role:edit')")
    @Log(title = "角色管理", businessType = BusinessType.UPDATE)
    public AjaxResult edit(@RequestBody SysRoleEntity role) {
        role.setUpdateBy(SecurityUtils.getUserId().toString());
        boolean up = service.updateById(role);
        roleMenuService.removeById(role.getRoleId());
        List<SysRoleMenuEntity> userRoleEntities = new ArrayList<>();
        for (Long roleId : role.getMenuIds()) {
            SysRoleMenuEntity roleMenuEntity = new SysRoleMenuEntity();
            roleMenuEntity.setRoleId(role.getRoleId());
            roleMenuEntity.setMenuId(roleId);
            userRoleEntities.add(roleMenuEntity);
        }
        boolean saveBatch = roleMenuService.saveBatch(userRoleEntities);
        return up ? AjaxResult.success("OK") : AjaxResult.error();
    }

    /**
     * 获取单个角色详情
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/{id}")
    @Log(title = "角色管理")
    public AjaxResult get(@PathVariable Long id) {
        SysRoleEntity byId = service.getById(id);
        byId.setMenuIds(service.selectMenuByRoleId(id));
        return AjaxResult.success(byId);

    }
}
