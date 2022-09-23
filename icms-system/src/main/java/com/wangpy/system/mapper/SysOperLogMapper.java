package com.wangpy.system.mapper;

import com.wangpy.common.core.domain.entity.SysOperLogEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 操作日志记录 Mapper 接口
 * </p>
 *
 * @author wangpy
 * @since 2022-09-21
 */
@Mapper
public interface SysOperLogMapper extends BaseMapper<SysOperLogEntity> {

}
