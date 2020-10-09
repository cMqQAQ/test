package com.jfsoft.interfaces.core.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.jfsoft.interfaces.core.entity.InterfaceLog;
import com.jfsoft.interfaces.core.entity.LogForm;

import java.util.List;

/**
 * <p>
 * 接口日志表 服务类
 * </p>
 *
 * @author chenxc
 * @since 2020-03-30
 */
public interface IInterfaceLogService extends IService<InterfaceLog> {

    /**
     * 获取日志列表
     *
     * @param log
     */
    List<InterfaceLog> list(LogForm log);

    /**
     * 获取日志列表总数
     *
     * @param log
     */
    Integer count(LogForm log);
}
