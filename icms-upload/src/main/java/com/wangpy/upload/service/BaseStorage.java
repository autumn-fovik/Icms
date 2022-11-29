package com.wangpy.upload.service;

/**
 * @Author: wangpy
 * @Description: 父级存储
 * @Date: Created in 2022/11/29 20:49
 */
public interface BaseStorage {
    /**
     * 文件上传
     *
     * @return
     * @Description 默认使用分片上传（实际以存储介质为准）
     */
    public Object upload();

    /**
     * 文件上传 ( 简单 )
     *
     * @return
     * @Description 使用直接上传 不分块上传 有大小限制（默认100MB 实际情况依照存储介质为准） 若超出大小 则默认调用 分块上传
     */
    public Object simpleUpload();

    /**
     * 断点续传
     *
     * @return
     * @Description 如果出现网络异常或程序崩溃导致文件上传失败时，将从断点记录处继续上传未上传完成的部分
     */
    public Object breakpointResume();

    /**
     * 文件下载
     *
     * @return
     * @Description 返回直链 如无法返回直链 则默认使用代理下载
     */
    public Object download();

    /**
     * 文件下载 (代理)
     *
     * @return
     * @Description: dawdwa
     * @Description 直接返回数据流 提供下载
     */
    public Object proxyDownload();


    /**
     * 获取列表
     *
     * @return
     * @Description 获取文件列表（默认获取根目录）
     */
    public Object getFileList();

    /**
     * 获取列表
     *
     * @param path 目录
     * @return
     * @Description 获取文件列表 （根据传入目录获取列表）
     */
    public Object getFileList(String path);

    /**
     * 获取文件信息
     *
     * @param filePath 文件路径
     * @return
     */
    public Object getFileInformation(String filePath);

    /**
     * 准备步骤
     *
     * @return
     */
    public Object readyToStep();


}
