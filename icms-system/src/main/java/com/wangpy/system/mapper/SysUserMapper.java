package com.wangpy.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wangpy.common.core.domain.entity.SysMenuEntity;
import com.wangpy.common.core.domain.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 用户信息表 Mapper 接口
 * </p>
 *
 * @author wangpy
 * @since 2022-09-21
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUserEntity> {
    /**
     * 查询用户拥有权限
     * @param userId
     * @return
     */
    public List<String> queryUserPermission(Long userId);

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    public SysUserEntity queryUserByUserName(String username);

    /**
     * 查询用户所有菜单
     * @param userId
     * @return
     */
    public List<SysMenuEntity> queryUserMenu(Long userId);

    /**
     * 根据用户ID查询用户
     * @param userId
     * @return
     */
    public SysUserEntity queryUserByUserId(Long userId);


}
