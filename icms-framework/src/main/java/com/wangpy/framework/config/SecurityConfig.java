package com.wangpy.framework.config;

import com.wangpy.framework.security.filter.JwtAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;

import javax.annotation.Resource;

/**
 * @Author: wangpy
 * @Description: Security 配置类
 * @Date: Created in 2022/8/15 23:02
 */
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
@EnableWebSecurity
public class SecurityConfig {
    /**
     * 自定义用户认证逻辑
     */
    @Resource
    private UserDetailsService userDetailsService;
    /**
     * 跨域过滤器
     */
    @Autowired
    private CorsFilter corsFilter;
    @Resource
    private AuthenticationEntryPoint authenticationEntryPoint;

    @Resource
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Autowired
    private AuthenticationConfiguration authenticationConfiguration;

    /**
     * 解决 无法直接注入 AuthenticationManager
     *
     * @return
     * @throws Exception
     */
//    @Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception
//    {
//        return super.authenticationManagerBean();
//    }
    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        AuthenticationManager authenticationManager = authenticationConfiguration.getAuthenticationManager();
        return authenticationManager;
    }

    //    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                // CSRF 禁用 不使用Session
//                .csrf().disable()
//                //  认证失败处理类
//                .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint).and()
//                // 基于Token 不使用Session
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//                // 过滤请求
//                .authorizeRequests()
//                // 部分URL无需权限即可访问
//                .antMatchers("/auth/login", "/", "/captchaImage", "/Interdiction").permitAll()
//                // 除特定请求不需要鉴权，其他均需要
//                .anyRequest().authenticated()
//                .and()
//                .headers().frameOptions().disable();
//        // 添加JWT filter
//        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
//        //http.addFilterBefore(coreFilter,JwtAuthenticationTokenFilter.class);
//        http.addFilterBefore(corsFilter, JwtAuthenticationTokenFilter.class);
//    }
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // CSRF 禁用 不使用Session
                .csrf().disable()
                //  认证失败处理类
                .exceptionHandling().authenticationEntryPoint(authenticationEntryPoint).and()
                // 基于Token 不使用Session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                // 过滤请求
                .authorizeRequests()
                // 部分URL无需权限即可访问
                .antMatchers("/auth/login", "/", "/captchaImage", "/Interdiction").permitAll()
                // 除特定请求不需要鉴权，其他均需要
                .anyRequest().authenticated()
                .and()
                .headers().frameOptions().disable();
        // 添加JWT filter
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
        //http.addFilterBefore(coreFilter,JwtAuthenticationTokenFilter.class);
        http.addFilterBefore(corsFilter, JwtAuthenticationTokenFilter.class);
        return http.build();
    }

    /**
     * 强散列哈希加密实现
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 身份认证接口
     */
//    @Override
//    @Bean
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception
//    {
//        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
//    }
}
