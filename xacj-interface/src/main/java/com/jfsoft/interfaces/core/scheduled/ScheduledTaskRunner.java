package com.jfsoft.interfaces.core.scheduled;


import com.jfsoft.interfaces.config.GlobalConfig;
import com.jfsoft.interfaces.core.entity.ScheduledTaskBean;
import com.jfsoft.interfaces.core.mapper.ScheduledTaskMapper;
import com.jfsoft.interfaces.core.service.IScheduledTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Order注解的执行优先级是按value值从小到大顺序。
 * 项目启动完毕后开启需要自启的任务
 *
 * @author cxc
 */
@Component
@Order(value = 1)
public class ScheduledTaskRunner implements ApplicationRunner {
    /**
     * 日志
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledTaskRunner.class);

    @Autowired
    private ScheduledTaskMapper taskMapper;

    @Autowired
    private IScheduledTaskService IScheduledTaskService;


    /**
     * 程序启动完毕后,需要自启的任务
     */
    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        LOGGER.info(" >>>>>> 项目启动完毕, 开启 => 需要自启的任务 开始!");
        List<ScheduledTaskBean> scheduledTaskBeanList = taskMapper.getAllNeedStartTask(GlobalConfig.MODULE_CODE);
        IScheduledTaskService.initAllTask(scheduledTaskBeanList);
        LOGGER.info(" >>>>>> 项目启动完毕, 开启 => 需要自启的任务 结束！");
    }
}
