package com.jfsoft.interfaces.core.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jfsoft.interfaces.core.entity.ScheduledTaskBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 定时任务表 mapper
 * 项目未使用 xml方式，使用注解方式查询数据以便演示
 *
 * @author cxc
 */
@Mapper
public interface ScheduledTaskMapper extends BaseMapper<ScheduledTaskBean> {

    /**
     * 根据key 获取 任务信息
     *
     * @param taskKey
     * @return
     */
    @Select("select task_key as taskKey,task_desc as taskDesc,task_cron as taskCron,init_start_flag as initStartFlag, " +
            "module_code as moduleCode from interface_scheduled_task where task_key = '${taskKey}' ")
    ScheduledTaskBean getByKey(@Param("taskKey") String taskKey);

    /**
     * 获取程序初始化需要自启的任务信息
     *
     * @return
     */
    @Select("select task_key as taskKey,task_desc as taskDesc,task_cron as taskCron,init_start_flag as initStartFlag, " +
            "module_code as moduleCode from interface_scheduled_task where init_start_flag = 1 and module_code = ${moduleCode}")
    List<ScheduledTaskBean> getAllNeedStartTask(@Param("moduleCode") Integer moduleCode);

    /**
     * 获取所有任务
     *
     * @return
     */
    @Select("select task_key as taskKey,task_desc as taskDesc,task_cron as taskCron,init_start_flag as initStartFlag, " +
            "module_code as moduleCode from interface_scheduled_task where module_code = ${moduleCode}")
    List<ScheduledTaskBean> getAllTask(@Param("moduleCode") Integer moduleCode);
}
