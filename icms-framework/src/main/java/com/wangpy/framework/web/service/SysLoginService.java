package com.wangpy.framework.web.service;

import com.wangpy.common.core.domain.AjaxResult;
import com.wangpy.common.core.domain.entity.SysMenuEntity;
import com.wangpy.common.core.domain.entity.SysUserEntity;
import com.wangpy.common.core.domain.model.LoginBody;
import com.wangpy.common.core.domain.model.LoginUser;
import com.wangpy.common.exception.ServiceException;
import com.wangpy.common.exception.user.UserPasswordNotMatchException;
import com.wangpy.common.utils.SecurityUtils;
import com.wangpy.system.entity.vo.MetaVo;
import com.wangpy.system.entity.vo.RouterVo;
import com.wangpy.system.mapper.SysUserMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: wangpy
 * @Description: 自定义登陆逻辑
 * @Date: Created in 2022/8/15 23:04
 */
@Component
public class SysLoginService {
    @Resource
    private AuthenticationManager authenticationManager;
    @Resource
    private TokenService tokenService;
    @Resource
    private SysUserMapper sysUserMapper;
    /**
     * 登陆验证
     * @param loginBody 登陆对象
     * @return Token
     */
    public String login(LoginBody loginBody){
        Authentication authentication =null;
        try {
            authentication  = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(loginBody.getUsername(),loginBody.getPassword()));
        }catch (Exception e){
            if (e instanceof BadCredentialsException)
            {
                throw new UserPasswordNotMatchException("用户名或密码错误");
            }
            else
            {
                throw new ServiceException(e.getMessage());
            }


        }
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        return tokenService.createToken(loginUser);
    }


    /**
     * 获取用户信息
     *
     * @return {@link SysUserEntity}
     */
    public SysUserEntity getUserInfo(){
        return  sysUserMapper.queryUserByUserId(SecurityUtils.getUserId());
    }

    /**
     * 获取用户路由
     *
     * @return {@link List}<{@link RouterVo}>
     */
    public List<RouterVo> getRoute(){
        Long userId = SecurityUtils.getUserId();
        List<SysMenuEntity> sysMenuEntities = sysUserMapper.queryUserMenu(userId);
        List<RouterVo> routerVos = compileRout(sysMenuEntities, 0L);
        return routerVos;

    }

    /**
     * 路由递归
     *
     * @param list 列表
     * @param pid  pid 父级ID
     * @return {@link List}<{@link RouterVo}>
     */
    private List<RouterVo> compileRout(List<SysMenuEntity> list , Long pid){
        List<RouterVo> li =new ArrayList<>();
        for (SysMenuEntity menu : list) {
            if (menu.getParentId().equals(pid)){
                RouterVo vo =new RouterVo();
                vo.setName(menu.getMenuName());
                vo.setPath(menu.getPath());
                vo.setHidden("0".equals(menu.getVisible()));
                vo.setComponent(menu.getComponent());
                vo.setMeta(new MetaVo(menu.getMenuId(),menu.getMenuName(),menu.getIcon(),1 == menu.getIsCache()));
                vo.setChildren(compileRout(list,menu.getMenuId()));
                li.add(vo);
            }
        }
        return li;

    }

}
