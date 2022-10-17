package com.wangpy.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wangpy.common.core.domain.entity.SysRoleMenuEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 角色和菜单关联表 Mapper 接口
 * </p>
 *
 * @author wangpy
 * @since 2022-09-21
 */
@Mapper
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenuEntity> {

}
