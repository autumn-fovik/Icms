package com.wangpy.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wangpy.common.core.domain.entity.SysMenuEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 菜单权限表 Mapper 接口
 * </p>
 *
 * @author wangpy
 * @since 2022-09-21
 */
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenuEntity> {

}
