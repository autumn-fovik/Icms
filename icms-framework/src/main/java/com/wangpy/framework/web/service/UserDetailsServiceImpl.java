package com.wangpy.framework.web.service;

import com.wangpy.common.constant.UserConstants;
import com.wangpy.common.core.domain.entity.SysMenuEntity;
import com.wangpy.common.core.domain.entity.SysUserEntity;
import com.wangpy.common.core.domain.model.LoginUser;
import com.wangpy.common.exception.user.UserException;
import com.wangpy.common.utils.StringUtils;
import com.wangpy.system.mapper.SysUserMapper;
import com.wangpy.system.service.SysUserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: wangpy
 * @Description: 自定义认证逻辑
 * @Date: Created in 2022/8/15 23:05
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private SysUserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUserEntity user = userMapper.queryUserByUserName(username);
        if (StringUtils.isNull(user)) {
            throw new UserException("登陆用户：" + username + " 不存在");

        } else if (UserConstants.USER_DISABLE.equals(user.getStatus())) {
            throw new UserException("对不起，您的账号：" + username + " 被停用");

        } else if (UserConstants.USER_DEl.equals(user.getDelFlag())) {
            throw new UserException("对不起，您的账号：" + username + " 被删除");

        }
        List<String> prem = userMapper.queryUserPermission(user.getUserId());
        HashSet<String> prems = new HashSet<String>(prem);
        return new LoginUser(user.getUserId(),prems,user);

    }
}
