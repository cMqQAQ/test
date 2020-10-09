package com.jfsoft.interfaces.task;

import com.jfsoft.interfaces.core.service.IScheduledTaskJob;
import lombok.extern.slf4j.Slf4j;

/**
 * @author chenxc
 * @email 997909544@qq.com
 * @date 2020/3/30  13:35
 */
@Slf4j
public class DemoTask implements IScheduledTaskJob {

    @Override
    public void run() {
        log.info("演示任务开始...");
    }
}
