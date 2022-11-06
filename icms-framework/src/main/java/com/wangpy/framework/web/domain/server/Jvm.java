package com.wangpy.framework.web.domain.server;

import com.wangpy.common.utils.DateUtils;
import lombok.Data;

import java.lang.management.ManagementFactory;

/**
 * @Author: wangpy
 * @Description: JVM相关信息
 * @Date: Created in 2022/11/4 12:45
 */
@Data
public class Jvm {
    /**
     * 当前JVM占用的内存总数(M)
     */
    private String total;

    /**
     * JVM最大可用内存总数(M)
     */
    private String max;

    /**
     * JVM空闲内存(M)
     */
    private String free;

    /**
     * JDK版本
     */
    private String version;

    /**
     * JDK路径
     */
    private String home;

    private String usage;

    private String used;


//    public double getUsage(double total ,double free)
//    {
//        return Arith.mul(Arith.div(total - free, total, 4), 100);
//    }

    /**
     * 获取JDK名称
     */
    public String getName() {
        return ManagementFactory.getRuntimeMXBean().getVmName();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getHome() {
        return home;
    }

    public void setHome(String home) {
        this.home = home;
    }

    /**
     * JDK启动时间
     */
    public String getStartTime() {
        return DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, DateUtils.getServerStartDate());
    }

    /**
     * JDK运行时间
     */
    public String getRunTime() {
        return DateUtils.getDatePoor(DateUtils.getNowDate(), DateUtils.getServerStartDate());
    }

    /**
     * 运行参数
     */
    public String getInputArgs() {
        return ManagementFactory.getRuntimeMXBean().getInputArguments().toString();
    }
}
