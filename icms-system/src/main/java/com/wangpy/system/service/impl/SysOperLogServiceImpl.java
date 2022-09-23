package com.wangpy.system.service.impl;

import com.wangpy.common.core.domain.entity.SysOperLogEntity;
import com.wangpy.system.mapper.SysOperLogMapper;
import com.wangpy.system.service.SysOperLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 操作日志记录 服务实现类
 * </p>
 *
 * @author wangpy
 * @since 2022-09-21
 */
@Service
public class SysOperLogServiceImpl extends ServiceImpl<SysOperLogMapper, SysOperLogEntity> implements SysOperLogService {

}
