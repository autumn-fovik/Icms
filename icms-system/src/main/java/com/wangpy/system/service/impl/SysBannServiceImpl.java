package com.wangpy.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangpy.common.core.domain.entity.SysBannEntity;
import com.wangpy.system.mapper.SysBannMapper;
import com.wangpy.system.service.SysBannService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户封禁表 服务实现类
 * </p>
 *
 * @author wangpy
 * @since 2022-11-27
 */
@Service
public class SysBannServiceImpl extends ServiceImpl<SysBannMapper, SysBannEntity> implements SysBannService {

}
