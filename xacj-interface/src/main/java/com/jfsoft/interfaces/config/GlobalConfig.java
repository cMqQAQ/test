package com.jfsoft.interfaces.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author chenxc
 * @email 997909544@qq.com
 * @Date 2019/10/16  18:25
 */
@Slf4j
@Component
public class GlobalConfig {

    @Autowired
    private Environment env;

    public static Integer LOG_DAYS;

    public static String DB_TYPE;

    public static Integer MODULE_CODE;

    public static String PREKEY;

    /**
     * 自定义配置
     */

    @PostConstruct
    public void readConfig() {
        LOG_DAYS = Integer.valueOf(env.getProperty("app.log-days"));
        DB_TYPE = env.getProperty("spring.datasource.dynamic.primary");
        MODULE_CODE = Integer.valueOf(env.getProperty("app.module-code"));
        PREKEY = env.getProperty("app.prekey");
    }
}
