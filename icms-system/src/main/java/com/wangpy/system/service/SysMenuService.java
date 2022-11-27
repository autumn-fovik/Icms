package com.wangpy.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wangpy.common.core.domain.entity.SysMenuEntity;

import java.util.List;

/**
 * <p>
 * 菜单权限表 服务类
 * </p>
 *
 * @author wangpy
 * @since 2022-09-21
 */
public interface SysMenuService extends IService<SysMenuEntity> {

    public List<SysMenuEntity> getMenuTree();

}
