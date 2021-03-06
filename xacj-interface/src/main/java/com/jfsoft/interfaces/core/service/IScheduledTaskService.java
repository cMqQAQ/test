package com.jfsoft.interfaces.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jfsoft.interfaces.core.entity.InterfaceLog;
import com.jfsoft.interfaces.core.entity.ScheduledTaskBean;

import java.util.List;

/**
 * 定时任务接口
 *
 * @author cxc
 */
public interface IScheduledTaskService extends IService<ScheduledTaskBean> {

    /**
     * 所有任务列表
     */
    List<ScheduledTaskBean> taskList();

    /**
     * 根据任务key 启动任务
     */
    Boolean start(String taskKey);

    /**
     * 根据任务key 停止任务
     */
    Boolean stop(String taskKey);

    /**
     * 根据任务key 重启任务
     */
    Boolean restart(String taskKey);

    /**
     * 根据任务key 手动执行任务
     */
    void runTask(String taskKey);


    /**
     * 程序启动时初始化  ==> 启动所有正常状态的任务
     */
    void initAllTask(List<ScheduledTaskBean> scheduledTaskBeanList);


    /**
     * 打印正在启动的任务
     */
    String printlnTask();

}
