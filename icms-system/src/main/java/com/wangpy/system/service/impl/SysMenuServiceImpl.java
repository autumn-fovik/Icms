package com.wangpy.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangpy.common.core.domain.entity.SysMenuEntity;
import com.wangpy.system.mapper.SysMenuMapper;
import com.wangpy.system.service.SysMenuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 菜单权限表 服务实现类
 * </p>
 *
 * @author wangpy
 * @since 2022-09-21
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenuEntity> implements SysMenuService {
   @Resource
    private SysMenuMapper mapper;
    public List<SysMenuEntity> getMenuTree() {
        return mapper.selectList(new QueryWrapper<SysMenuEntity>().orderByAsc(SysMenuEntity.ORDER_NUM));


    }
}
