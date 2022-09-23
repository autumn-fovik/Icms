package com.wangpy.framework.web.service;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.wangpy.common.core.domain.model.LoginUser;
import com.wangpy.common.utils.SecurityUtils;
import com.wangpy.common.utils.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @Author: wangpy
 * @Description: 权限鉴权类
 * @Date: Created in 2022/8/15 23:03
 */
@Service(value = "ss")
public class PermissionService {
    /**
     * 验证用户是否具备某权限
     *
     * @param permission 权限字符串
     * @return 用户是否具备某权限
     */
    public boolean hasPermi(String permission)
    {
        // 判断权限是否为空
        if (StringUtils.isEmpty(permission))
        {
            return false;
        }
        // 获取当前登陆用户信息
        LoginUser loginUser = SecurityUtils.getLoginUser();
        // 判断 当前登陆用户信息是否为空
        if (StringUtils.isNull(loginUser) || CollectionUtils.isEmpty(loginUser.getPermissions()))
        {
            return false;
        }
        return hasPermissions(loginUser.getPermissions(), permission);
    }
    /**
     * 判断是否包含权限
     *
     * @param permissions 权限列表
     * @param permission 权限字符串
     * @return 用户是否具备某权限
     */
    private boolean hasPermissions(Set<String> permissions, String permission)
    {
        return  permissions.contains(StringUtils.trim(permission));
    }

}
