package com.wangpy.system.service;

import com.wangpy.common.core.domain.entity.SysUserEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户信息表 服务类
 * </p>
 *
 * @author wangpy
 * @since 2022-09-21
 */
public interface SysUserService extends IService<SysUserEntity> {
    /**
     * 查询用户拥有的权限
     * @param userId
     * @return
     */
    public List<String> queryUserPermission(String userId);

}
