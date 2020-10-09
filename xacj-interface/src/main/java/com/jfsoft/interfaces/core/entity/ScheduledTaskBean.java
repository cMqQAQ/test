package com.jfsoft.interfaces.core.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author cxc
 * @version ScheduledTaskBean.java, v 3.0 2018-12-23 18:59
 */
@Data
@TableName("interface_scheduled_task")
public class ScheduledTaskBean {

    /**
     * 任务key值 唯一
     */
    private String taskKey;
    /**
     * 任务描述
     */
    private String taskDesc;
    /**
     * 任务表达式
     */
    private String taskCron;

    /**
     * 程序初始化是否启动 1 是 0 否
     */
    private Integer initStartFlag;

    /**
     * 当前是否已启动
     */
    @TableField(exist = false)
    private boolean startFlag;

    /**
     * 模块代码
     */
    private Integer moduleCode;

    /**
     * 模块名称
     */
    @TableField(exist = false)
    private String moduleName;
}
