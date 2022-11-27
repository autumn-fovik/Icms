package com.wangpy.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wangpy.common.core.domain.entity.SysBannEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户封禁表 Mapper 接口
 * </p>
 *
 * @author wangpy
 * @since 2022-11-27
 */
@Mapper
public interface SysBannMapper extends BaseMapper<SysBannEntity> {

}
