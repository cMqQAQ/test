package com.jfsoft.interfaces.core.entity;

import lombok.Data;

/**
 * @author chenxc
 * @email 997909544@qq.com
 * @date 2020/4/3  9:20
 */
@Data
public class TaskForm {
    private String taskKey;

    private String taskCron;

    private String taskDesc;
}
