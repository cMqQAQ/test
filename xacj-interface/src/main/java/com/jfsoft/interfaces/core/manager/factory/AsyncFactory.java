package com.jfsoft.interfaces.core.manager.factory;


import com.jfsoft.interfaces.core.entity.InterfaceLog;
import com.jfsoft.interfaces.core.service.IInterfaceLogService;
import com.jfsoft.interfaces.utils.ServletUtil;
import com.jfsoft.interfaces.utils.SpringUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.TimerTask;

/**
 * @author chenxc
 * @email 997909544@qq.com
 * @Date 2019/10/23  13:56
 */
@Slf4j
public class AsyncFactory {

    /**
     * 记录接口日志
     *
     * @return 任务task
     */
    public static TimerTask recordLog(final InterfaceLog log) {
        return new TimerTask() {
            @Override
            public void run() {
                SpringUtil.getBean(IInterfaceLogService.class).save(log);
            }
        };
    }
}
