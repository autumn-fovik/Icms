package com.wangpy.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wangpy.common.controller.BaseController;
import com.wangpy.common.core.domain.AjaxResult;
import com.wangpy.common.core.domain.entity.SysMenuEntity;
import com.wangpy.system.service.SysMenuService;
import org.springframework.web.bind.annotation.*;

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
        return AjaxResult.success(service.list(new QueryWrapper<SysMenuEntity>().orderByAsc(SysMenuEntity.ORDER_NUM)));


    }

    /**
     * 获取全部菜单（树形）
     * @return
     */
    @GetMapping(value = "page")
    public AjaxResult listTree(){
        startPage();
        List<SysMenuEntity> list = service.list();
        return AjaxResult.success(getDataTable(list));
    }
    @PutMapping(value = "")
    public AjaxResult add(@RequestBody SysMenuEntity sysMenuEntity){
        return AjaxResult.success(service.save(sysMenuEntity));
    }

    @PostMapping(value = "")
    public AjaxResult edit(@RequestBody SysMenuEntity sysMenuEntity){
        return AjaxResult.success(service.updateById(sysMenuEntity));
    }
    @GetMapping(value = "/{id}")
    public AjaxResult get(@PathVariable Long id){
        return AjaxResult.success(service.getById(id));
    }


}
