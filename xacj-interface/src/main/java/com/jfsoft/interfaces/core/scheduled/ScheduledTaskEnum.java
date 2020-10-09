package com.jfsoft.interfaces.core.scheduled;

import com.jfsoft.interfaces.core.service.IScheduledTaskJob;
import com.jfsoft.interfaces.task.ClearLogTask;
import com.jfsoft.interfaces.task.DemoTask;
import lombok.Getter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 定时任务枚举值
 * 注：key 需要与数据库任务表 taks_key 保持一致
 * 此数据也可以维护到表里
 *
 * @author cxc
 */
@Getter
public enum ScheduledTaskEnum {

    /**
     * 任务列表
     */
    TASK_DEMO("DemoTask", new DemoTask()),
    TASK_CLEAR_LOG("ClearLogTask", new ClearLogTask());

    /**
     * 定时任务key
     */
    private String taskKey;

    /**
     * 定时任务 执行实现类
     */
    private IScheduledTaskJob IScheduledTaskJob;

    ScheduledTaskEnum(String taskKey, IScheduledTaskJob IScheduledTaskJob) {
        this.taskKey = taskKey;
        this.IScheduledTaskJob = IScheduledTaskJob;
    }

    /**
     * 初始化 所有任务
     */
    public static Map<String, IScheduledTaskJob> initScheduledTask() {
        if (ScheduledTaskEnum.values().length < 0) {
            return new ConcurrentHashMap<>();
        }
        Map<String, IScheduledTaskJob> scheduledTaskJobMap = new ConcurrentHashMap<>();
        for (ScheduledTaskEnum taskEnum : ScheduledTaskEnum.values()) {
            scheduledTaskJobMap.put(taskEnum.taskKey, taskEnum.IScheduledTaskJob);
        }
        return scheduledTaskJobMap;
    }

    public static IScheduledTaskJob getTask(String taskKey) {
        for (ScheduledTaskEnum task : values()) {
            if (taskKey.equals(task.getTaskKey())) {
                return task.getIScheduledTaskJob();
            }
        }
        return null;
    }
}
