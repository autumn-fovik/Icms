package com.wangpy.common.core.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: wangpy
 * @Description: 用户登陆对象
 * @Date: Created in 2022/9/21 16:24
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginBody {
    private String username;
    private String password;
}
