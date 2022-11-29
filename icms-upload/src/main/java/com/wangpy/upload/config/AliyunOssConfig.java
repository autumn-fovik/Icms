package com.wangpy.upload.config;

import org.springframework.beans.factory.annotation.Value;

/**
 * @Author: wangpy
 * @Description: 阿里云 OSS 配置
 * @Date: Created in 2022/11/29 21:11
 */
public class AliyunOssConfig {
    /**
     * 地域
     */
    @Value("aliyun.endpoint")
    private String endpoint = "yourEndpoint";
    /**
     * 账号
     */
    @Value("aliyun.accessKeyId")
    private String accessKeyId = "yourAccessKeyId";
    /**
     * 密钥
     */
    @Value("aliyun.accessKeySecret")
    private String accessKeySecret = "yourAccessKeySecret";
}
