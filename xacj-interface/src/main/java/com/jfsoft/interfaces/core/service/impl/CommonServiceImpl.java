package com.jfsoft.interfaces.core.service.impl;

import com.jfsoft.interfaces.core.filter.SqlFilter;
import com.jfsoft.interfaces.core.mapper.CommonMapper;
import com.jfsoft.interfaces.core.service.ICommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chenxc
 * @email 997909544@qq.com
 * @date 2020/3/31  9:33
 */
@Service
public class CommonServiceImpl implements ICommonService {

    @Autowired
    CommonMapper commonMapper;

    /**
     * 通用sql执行
     *
     * @param sqlStr sql语句
     * @return List<Map < String, Object>>
     * @Author: Lxd
     * @Date: 2019/9/12 10:48
     */
    @Override
    public List<Map<String, Object>> execSql(String sqlStr) {
        return commonMapper.execSql(sqlStr);
    }

    /**
     * 通用存储过程执行
     *
     * @Author Lxd
     * @Date 8:44 2019/9/12
     * @Param [procName, params]
     * @Return
     **/
    @Override
    public void execProc(String procName, String params) {
        Map<String, Object> map = new HashMap<>(2);
        map.put("procName", procName);
        map.put("params", params);
        commonMapper.execProc(map);
    }
}
