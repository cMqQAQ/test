package com.jfsoft.interfaces.utils;

import com.baomidou.mybatisplus.annotation.DbType;
import lombok.Data;

/**
 * 代码生成配置
 *
 * @author chenxc
 * @email 997909544@qq.com
 * @date 2020/3/23  11:36
 */
@Data
public class GenerateConfig {

    /**
     * 工程路径
     */
    private String projectPath;

    /**
     * 输出目录
     */
    private String outputDir;

    /**
     * 作者
     */
    private String author;

    /**
     * 是否开始swagger
     */
    private boolean swagger;

    /**
     * 数据库url
     */
    private String url;

    /**
     * 数据库
     */
    private DbType dbType;

    /**
     * 驱动名称
     */
    private String driverName;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 模块名称
     * eg: sys
     */
    private String moduleName;

    /**
     * 父包
     * eg: com.jfsoft
     */
    private String parent;

    /**
     * 需要生成的表名，多个用','分隔
     */
    private String[] tableNames;
}
