package com.wangpy.framework.security.handle;

import com.alibaba.fastjson2.JSON;
import com.wangpy.common.constant.AjaxResultStatus;
import com.wangpy.common.core.domain.AjaxResult;
import com.wangpy.common.utils.ServletUtils;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: wangpy
 * @Description: 自定义认证错误处理
 * @Date: Created in 2022/8/15 23:06
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        String msg = String.format("请求访问：%s，认证失败，无法访问系统资源", request.getRequestURI());
        ServletUtils.renderString(response, JSON.toJSONString(AjaxResult.ajaxResultStatus(AjaxResultStatus.UNAUTHORIZED, msg)));
    }
}
