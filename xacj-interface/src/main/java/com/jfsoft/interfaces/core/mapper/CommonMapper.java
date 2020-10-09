package com.jfsoft.interfaces.core.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author chenxc
 * @email 997909544@qq.com
 * @date 2020/3/31  9:34
 */
@Mapper
public interface CommonMapper {

    /**
     * 通用 SQL 执行
     *
     * @Author Lxd
     * @Date 8:47 2019/9/12
     * @Param [sqlStr]
     * @Return
     **/
    List<Map<String, Object>> execSql(String sqlStr);


    /**
     * 通用存储过程执行
     *
     * @Author Lxd
     * @Date 8:46 2019/9/12
     * @Param [params]
     * @Return
     **/
    void execProc(Map<String, Object> params);

}
