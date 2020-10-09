package com.jfsoft.interfaces.http;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jfsoft.interfaces.core.entity.ScheduledTaskBean;
import com.jfsoft.interfaces.core.service.ICommonService;
import com.jfsoft.interfaces.core.service.IScheduledTaskService;
import com.jfsoft.interfaces.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 定时任务 controller
 *
 * @author cxc
 */
@RestController
@RequestMapping("/scheduled")
public class ScheduledController {

    @Autowired
    private IScheduledTaskService scheduledTaskService;

    @Autowired
    private ICommonService commonService;

    /**
     * 所有任务列表
     */
    @RequestMapping("/taskList")
    public R taskList() {
        List<ScheduledTaskBean> list = scheduledTaskService.taskList();
        return R.ok().put("data", list);
    }

    /**
     * 根据任务key => 启动任务
     */
    @RequestMapping("/start")
    public R start(@RequestParam("taskKey") String taskKey) {
        scheduledTaskService.start(taskKey);
        return R.ok("服务已启动");
    }

    /**
     * 根据任务key => 停止任务
     */
    @RequestMapping("/stop")
    public R stop(@RequestParam("taskKey") String taskKey) {
        scheduledTaskService.stop(taskKey);
        return R.ok("服务已停止");
    }

    /**
     * 根据任务key => 执行任务
     */
    @RequestMapping("/run")
    public R run(@RequestParam("taskKey") String taskKey) {
        scheduledTaskService.runTask(taskKey);
        return R.ok("任务已执行");
    }

    /**
     * 根据任务key => 重启任务
     */
    @RequestMapping("/restart")
    public R restart(@RequestParam("taskKey") String taskKey) {
        scheduledTaskService.restart(taskKey);
        return R.ok("服务已重启");
    }

    @RequestMapping("/printlnTask")
    public R printlnTask() {
        String task = scheduledTaskService.printlnTask();
        return R.ok().put("data", task);
    }

    @RequestMapping("/editTask")
    public R editTask(@RequestBody ScheduledTaskBean task) {
        QueryWrapper<ScheduledTaskBean> wrapper = new QueryWrapper<>();
        wrapper.eq("task_key", task.getTaskKey());
        ScheduledTaskBean taskBean = scheduledTaskService.getOne(wrapper);
        taskBean.setTaskCron(task.getTaskCron());
        taskBean.setTaskDesc(task.getTaskDesc());
        scheduledTaskService.update(taskBean, wrapper);
        return R.ok().put("data", task);
    }
}
