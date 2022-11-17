package com.wangpy.admin.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wangpy.common.core.controller.BaseController;
import com.wangpy.common.core.domain.AjaxResult;
import com.wangpy.common.core.domain.entity.SysOperLogEntity;
import com.wangpy.system.service.SysOperLogService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author: wangpy
 * @Description: 操作日志访问控制器
 * @Date: Created in 2022/11/11 21:34
 */
@RestController
@RequestMapping(value = "log")
public class SysOperLogController extends BaseController {
    @Resource
    private SysOperLogService service;

    @GetMapping
    public AjaxResult list() {
        startPage();
        QueryWrapper<SysOperLogEntity> queryWrapper = new QueryWrapper<>();
        return AjaxResult.success(getDataTable(service.list(queryWrapper.orderByDesc(SysOperLogEntity.OPER_ID))));
    }

    @GetMapping(value = "{id}")
    public AjaxResult get(@PathVariable(value = "id") Long id) {
        return AjaxResult.success(service.getById(id));

    }


}
