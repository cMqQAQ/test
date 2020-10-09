package com.jfsoft.interfaces.business;

import com.baomidou.mybatisplus.annotation.DbType;
import com.jfsoft.interfaces.utils.GenerateConfig;
import com.jfsoft.interfaces.utils.GenerateUtil;

/**
 * 代码生成
 *
 * @author chenxc
 * @email 997909544@qq.com
 * @date 2020/3/23  13:11
 */
public class Generator {
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        GenerateConfig config = new GenerateConfig();
        config.setProjectPath(projectPath);
        config.setOutputDir(projectPath + "/src/main/java");
        config.setAuthor("chenxc");
        config.setSwagger(true);
        config.setDbType(DbType.SQL_SERVER);
        config.setUrl("jdbc:sqlserver://10.0.2.178:1433;DatabaseName=lis");
        config.setDriverName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        config.setUsername("sa");
        config.setPassword("123");
        config.setModuleName("business");
        config.setParent("com.jfsoft.interfaces");
        config.setTableNames(new String[]{"PatientBase"});
        GenerateUtil.run(config);
    }
}
