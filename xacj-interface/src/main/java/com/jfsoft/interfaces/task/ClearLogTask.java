package com.jfsoft.interfaces.task;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.annotation.DbType;
import com.jfsoft.interfaces.config.GlobalConfig;
import com.jfsoft.interfaces.core.service.ICommonService;
import com.jfsoft.interfaces.core.service.IScheduledTaskJob;
import com.jfsoft.interfaces.utils.SpringUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author chenxc
 * @email 997909544@qq.com
 * @date 2020/3/30  13:35
 */
@Slf4j
public class ClearLogTask implements IScheduledTaskJob {

    private ICommonService commonService;

    @Override
    public void run() {
        log.info("清除日志开始...");
        commonService = SpringUtil.getBean(ICommonService.class);
        String sql = StrUtil.EMPTY;
        if (GlobalConfig.DB_TYPE.equalsIgnoreCase(DbType.SQL_SERVER.getDb())) {
            sql = StrUtil.format("delete from interface_log where execution_time <= getdate() - {}",
                    GlobalConfig.LOG_DAYS);
        } else if (GlobalConfig.DB_TYPE.equalsIgnoreCase(DbType.MYSQL.getDb())) {
            sql = StrUtil.format("delete from interface_log where execution_time <= DATE_SUB(NOW(), INTERVAL {} DAY)",
                    GlobalConfig.LOG_DAYS);
        } else {
            sql = StrUtil.format("delete from interface_log where execution_time <= sysdate - {}",
                    GlobalConfig.LOG_DAYS);
        }
        commonService.execSql(sql);
        log.info("清除日志清除完毕...");
    }
}
