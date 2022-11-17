package com.wangpy.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wangpy.common.annotation.Log;
import com.wangpy.common.constant.AjaxResultStatus;
import com.wangpy.common.constant.UserConstants;
import com.wangpy.common.core.controller.BaseController;
import com.wangpy.common.core.domain.AjaxResult;
import com.wangpy.common.core.domain.entity.SysUserEntity;
import com.wangpy.common.core.domain.entity.SysUserRoleEntity;
import com.wangpy.common.enums.BusinessType;
import com.wangpy.common.utils.SecurityUtils;
import com.wangpy.system.service.SysUserRoleService;
import com.wangpy.system.service.SysUserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    @Resource
    public SysUserRoleService userRoleService;
    @Resource
    public BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * 查询全部用户
     *
     * @return
     */
    @GetMapping(value = "")
    @PreAuthorize(value = "@ss.hasPermi('system:user:list')")
    @Log(title = "用户管理")
    public AjaxResult list(SysUserEntity sysUserEntity) {
        startPage();
        QueryWrapper<SysUserEntity> queryWrapper = new QueryWrapper<>();
        if (sysUserEntity.getUserName() != null && !"".equals(sysUserEntity.getUserName()))
            queryWrapper.like(SysUserEntity.USER_NAME, sysUserEntity.getUserName());
        if (sysUserEntity.getEmail() != null && !"".equals(sysUserEntity.getEmail()))
            queryWrapper.like(SysUserEntity.EMAIL, sysUserEntity.getEmail());

        List<SysUserEntity> list = service.list(queryWrapper);
        return AjaxResult.success(getDataTable(list));

    }

    /**
     * 查询单个用户
     * @param id 用户id
     * @return
     */
    @GetMapping(value = "{id}")
    @Log(title = "用户管理")
    public AjaxResult queryUserById(@PathVariable(value = "id") String id){
        SysUserEntity byId = service.getById(id);
        List<SysUserRoleEntity> list = userRoleService.list(new QueryWrapper<SysUserRoleEntity>().eq(SysUserRoleEntity.USER_ID, byId.getUserId()));
        Set<Long> set = new HashSet<>();
        for (SysUserRoleEntity sysUserRoleEntity : list) {
            set.add(sysUserRoleEntity.getRoleId());
        }
        byId.setRoleIds(set);
        return AjaxResult.success("OK",byId);
    }

    /**
     * 编辑用户
     *
     * @param sysUserEntity
     * @return
     */
    @PostMapping()
    @PreAuthorize(value = "@ss.hasPermi('system:user:edit')")
    @Log(title = "用户管理", businessType = BusinessType.UPDATE)
    public AjaxResult editUser(@RequestBody SysUserEntity sysUserEntity) {
        QueryWrapper<SysUserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SysUserEntity.USER_NAME, sysUserEntity.getUserName());
        queryWrapper.or().eq(SysUserEntity.EMAIL, sysUserEntity.getEmail());
        queryWrapper.ne(SysUserEntity.USER_ID, sysUserEntity.getUserId());
        SysUserEntity one = service.getOne(queryWrapper);
        if (one != null) {
            if (!one.getUserId().equals(sysUserEntity.getUserId())) {
                if (sysUserEntity.getEmail().equals(one.getEmail()))
                    return AjaxResult.ajaxResultStatus(AjaxResultStatus.SMALL_MISTAKE, "邮箱重复");
                if (sysUserEntity.getUserName().equals(one.getUserName()))
                    return AjaxResult.ajaxResultStatus(AjaxResultStatus.SMALL_MISTAKE, "用户名重复");
            }
        }
        userRoleService.removeById(sysUserEntity.getUserId());
        List<SysUserRoleEntity> userRoleEntity = new ArrayList<>();
        for (Long roleId : sysUserEntity.getRoleIds()) {
            SysUserRoleEntity s = new SysUserRoleEntity(sysUserEntity.getUserId(), roleId);
            userRoleEntity.add(s);
        }
        userRoleService.saveBatch(userRoleEntity);
        boolean b = service.updateById(sysUserEntity);
        return AjaxResult.success("OK", b);
    }

    /**
     * 添加用户
     *
     * @param sysUserEntity
     * @return
     */
    @PutMapping()
    @PreAuthorize(value = "@ss.hasPermi('system:user:add')")
    @Log(title = "用户管理", businessType = BusinessType.INSERT)
    public AjaxResult addUser(@RequestBody SysUserEntity sysUserEntity) {
        // 查询用户名或邮箱是否重复
        QueryWrapper<SysUserEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(SysUserEntity.USER_NAME, sysUserEntity.getUserName());
        queryWrapper.or().eq(SysUserEntity.EMAIL, sysUserEntity.getEmail());
        SysUserEntity one = service.getOne(queryWrapper);

        if (one != null) {
            if (sysUserEntity.getEmail().equals(one.getEmail()))
                return AjaxResult.ajaxResultStatus(AjaxResultStatus.SMALL_MISTAKE, "邮箱重复");
            if (sysUserEntity.getUserName().equals(one.getUserName()))
                return AjaxResult.ajaxResultStatus(AjaxResultStatus.SMALL_MISTAKE, "用户名重复");

        }
        if (sysUserEntity.getPassword().equals("")) {
            sysUserEntity.setPassword(bCryptPasswordEncoder.encode("123456"));
        } else {
            sysUserEntity.setPassword(bCryptPasswordEncoder.encode(sysUserEntity.getPassword()));
        }
        // 添加用户
        boolean b = service.save(sysUserEntity);
        return AjaxResult.success("OK", b);
    }

    /**
     * 删除用户（仅添加删除标识）
     *
     * @param id
     * @return
     */
    @DeleteMapping(value = "{id}")
    @PreAuthorize(value = "@ss.hasPermi('system:user:del')")
    @Log(title = "用户管理", businessType = BusinessType.DELETE)
    public AjaxResult delUser(@PathVariable(value = "id") String id, SysUserEntity sysUserEntity) {
        SysUserEntity user = new SysUserEntity();
        user.setUserId(id);
        user.setDelFlag(UserConstants.USER_DEl);
        user.setRemark(sysUserEntity.getRemark());
        boolean b = service.updateById(user);
        return AjaxResult.success("OK", b);
    }

    /**
     * 修改用户状态
     * @param id
     * @param status
     * @return
     */
    @PostMapping("status/{id}/{status}")
    @PreAuthorize(value = "@ss.hasPermi('system:user:edit')")
    @Log(title = "用户管理", businessType = BusinessType.UPDATE)
    public AjaxResult userStatusEdit(@PathVariable(value = "id") String id ,@PathVariable(value = "status") String status) {

        if (SecurityUtils.getUserId().equals(id) && "1".equals(status))
            return AjaxResult.ajaxResultStatus(AjaxResultStatus.SMALL_MISTAKE,"不允许更新自身账号状态!");
        SysUserEntity user = new SysUserEntity();
        user.setUserId(id);
        user.setStatus(status);
        boolean b = service.updateById(user);
        return AjaxResult.success("OK",b);
    }
}
