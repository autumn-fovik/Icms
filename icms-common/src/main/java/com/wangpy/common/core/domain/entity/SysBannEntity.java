package com.wangpy.common.core.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户封禁表
 * </p>
 *
 * @author wangpy
 * @since 2022-11-27
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("sys_bann")
public class SysBannEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 封禁表主键
     */
    @TableId(value = "bann_id", type = IdType.AUTO)
    private Integer bannId;

    /**
     * 用户id
     */
    @TableField("user_id")
    private String userId;

    /**
     * 封禁类型  1 系统封禁   2 手动封禁
     */
    @TableField("type_ban")
    private Integer typeBan;

    /**
     * 封禁原因
     */
    @TableField("reason")
    private String reason;

    /**
     * 开始时间
     */
    @TableField("start_time")
    private Date startTime;

    /**
     * 结束时间
     */
    @TableField("end_time")
    private Date endTime;


    public static final String BANN_ID = "bann_id";

    public static final String USER_ID = "user_id";

    public static final String TYPE_BAN = "type_ban";

    public static final String REASON = "reason";

    public static final String START_TIME = "start_time";

    public static final String END_TIME = "end_time";

}
