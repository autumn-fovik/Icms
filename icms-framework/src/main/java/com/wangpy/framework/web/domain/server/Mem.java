package com.wangpy.framework.web.domain.server;

import lombok.Data;

/**
 * @Author: wangpy
 * @Description: 内存相关信息
 * @Date: Created in 2022/11/4 12:45
 */
@Data
public class Mem {
    /**
     * 内存总量
     */
    private String total;

    /**
     * 已用内存
     */
    private String used;

    /**
     * 剩余内存
     */
    private String free;

    private String usage;


}
