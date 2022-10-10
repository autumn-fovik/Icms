package com.wangpy.admin.controller;

import com.wangpy.common.controller.BaseController;
import com.wangpy.common.core.domain.AjaxResult;
import com.wangpy.common.core.domain.entity.SysUserEntity;
import com.wangpy.system.service.SysUserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    /**
     * 查询全部用户
     * @return
     */
    @GetMapping(value = "list")
    @PreAuthorize(value = "@ss.hasPermi('system:user:list')")
    public AjaxResult list(){
        startPage();
        List<SysUserEntity> list = service.list();
        return AjaxResult.success(getDataTable(list));

    }

    /**
     * 查询单个用户
     * @param id 用户id
     * @return
     */
    @GetMapping(value = "{id}")
    @PreAuthorize(value = "@ss.hasPermi('system:user:list')")
    public AjaxResult queryUserById(@PathVariable(value = "id") String id){
        SysUserEntity byId = service.getById(id);
        return AjaxResult.success("OK",byId);
    }

    /**
     * 编辑用户
     * @param sysUserEntity
     * @return
     */
    @PostMapping()
    @PreAuthorize(value = "@ss.hasPermi('system:user:edit')")
    public AjaxResult editUser(@RequestBody SysUserEntity sysUserEntity){
        boolean b = service.updateById(sysUserEntity);
        return AjaxResult.success("OK",b);
    }

    /**
     * 添加用户
     * @param sysUserEntity
     * @return
     */
    @PutMapping()
    @PreAuthorize(value = "@ss.hasPermi('system:user:add')")
    public AjaxResult addUser(@RequestBody SysUserEntity sysUserEntity){
        boolean b = service.save(sysUserEntity);
        return AjaxResult.success("OK",b);
    }

    /**
     * 删除用户（仅添加删除标识）
     * @param id
     * @return
     */
    @DeleteMapping(value = "{id}")
    @PreAuthorize(value = "@ss.hasPermi('system:user:del')")
    public AjaxResult delUser(@PathVariable(value = "id") String id){
        SysUserEntity user= new SysUserEntity();
        user.setUserId(id);
        user.setDelFlag("2");
        boolean b = service.updateById(user);
        return AjaxResult.success("OK",b);
    }

    /**
     * 修改用户状态
     * @param id
     * @param status
     * @return
     */
    @PostMapping("status/{id}/{status}")
    public AjaxResult userStatusEdit(@PathVariable(value = "id") String id ,@PathVariable(value = "status") String status) {
        SysUserEntity user = new SysUserEntity();
        user.setUserId(id);
        user.setStatus(status);
        boolean b = service.updateById(user);
        return AjaxResult.success("OK",b);
    }
}
