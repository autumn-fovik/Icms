package com.wangpy.system.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.List;

/**
 * @Author: wangpy
 * @Description: TODO
 * @Date: Created in 2022/8/27 21:00
 */
@Data
public class UserVo {
    /**
     * 用户账号
     */
    @TableField("user_name")
    private String userName;

    /**
     * 用户昵称
     */
    @TableField("nick_name")
    private String nickName;

    /**
     * 用户邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 用户性别（0男 1女 2未知）
     */
    @TableField("sex")
    private String sex;

    /**
     * 头像地址
     */
    @TableField("avatar")
    private String avatar;

    /**
     * 帐号状态（0正常 1停用）
     */
    @TableField("status")
    private String status;

    /**
     * 权限列表
     */
    @TableField("permissions")
    private List<String> permissions;


}
