package com.wangpy.common.core.domain.entity;

import com.alibaba.fastjson2.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 操作日志记录
 * </p>
 *
 * @author wangpy
 * @since 2022-09-21
 */
@Getter
@Setter
@TableName("sys_oper_log")
@ToString
public class SysOperLogEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 日志主键
     */
    @TableId(value = "oper_id", type = IdType.AUTO)
    private Long operId;

    /**
     * 模块标题
     */
    @TableField("title")
    private String title;

    /**
     * 业务类型（0其它 1新增 2修改 3删除）
     */
    @TableField("business_type")
    private Integer businessType;

    /**
     * 方法名称
     */
    @TableField("method")
    private String method;

    /**
     * 请求方式
     */
    @TableField("request_method")
    private String requestMethod;

    /**
     * 操作类别（0其它 1后台用户 2手机端用户）
     */
    @TableField("operator_type")
    private Integer operatorType;

    /**
     * 操作人员
     */
    @TableField("oper_name")
    private String operName;


    /**
     * 请求URL
     */
    @TableField("oper_url")
    private String operUrl;

    /**
     * 主机地址
     */
    @TableField("oper_ip")
    private String operIp;

    /**
     * 操作地点
     */
    @TableField("oper_location")
    private String operLocation;

    /**
     * 请求参数
     */
    @TableField("oper_param")
    private String operParam;

    /**
     * 返回参数
     */
    @TableField("json_result")
    private String jsonResult;

    /**
     * 操作状态（0正常 1异常）
     */
    @TableField("status")
    private Integer status;

    /**
     * 错误消息
     */
    @TableField("error_msg")
    private String errorMsg;

    /**
     * 操作时间
     */
    @TableField("oper_time")
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime operTime;


    public static final String OPER_ID = "oper_id";

    public static final String TITLE = "title";

    public static final String BUSINESS_TYPE = "business_type";

    public static final String METHOD = "method";

    public static final String REQUEST_METHOD = "request_method";

    public static final String OPERATOR_TYPE = "operator_type";

    public static final String OPER_NAME = "oper_name";

    public static final String OPER_URL = "oper_url";

    public static final String OPER_IP = "oper_ip";

    public static final String OPER_LOCATION = "oper_location";

    public static final String OPER_PARAM = "oper_param";

    public static final String JSON_RESULT = "json_result";

    public static final String STATUS = "status";

    public static final String ERROR_MSG = "error_msg";

    public static final String OPER_TIME = "oper_time";

}
