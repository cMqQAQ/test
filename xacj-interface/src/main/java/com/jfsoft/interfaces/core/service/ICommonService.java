package com.jfsoft.interfaces.core.service;

import java.util.List;
import java.util.Map;

/**
 * 公共服务
 *
 * @author chenxc
 * @email 997909544@qq.com
 * @date 2020/3/31  9:32
 */
public interface ICommonService {

    /**
     * 通用sql执行
     *
     * @param sqlStr sql语句
     * @return List<Map < String, Object>>
     * @Author: Lxd
     * @Date: 2019/9/12 10:48
     */
    List<Map<String, Object>> execSql(String sqlStr);

    /**
     * 通用执行存储过程
     *
     * @param procName 存储过程名称
     * @param params   语句
     * @return void
     * @Author: Lxd
     * @Date: 2019/9/12 10:48
     */
    void execProc(String procName, String params);
}
