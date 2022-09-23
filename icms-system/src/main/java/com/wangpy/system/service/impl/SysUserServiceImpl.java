package com.wangpy.system.service.impl;

import com.wangpy.common.core.domain.entity.SysUserEntity;
import com.wangpy.system.mapper.SysUserMapper;
import com.wangpy.system.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author wangpy
 * @since 2022-09-21
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUserEntity> implements SysUserService {
    @Resource
    private SysUserMapper userMapper;

    @Override
    public List<String> queryUserPermission(Long userId) {
        return userMapper.queryUserPermission(userId);
    }

}
