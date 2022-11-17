package com.wangpy.common.utils;

/**
 * @Author: wangpy
 * @Description: 日志工具
 * @Date: Created in 2022/11/11 21:13
 */
public class LogUtils {
    public static String getBlock(Object msg) {
        if (msg == null) {
            msg = "";
        }
        return "[" + msg.toString() + "]";
    }
}
