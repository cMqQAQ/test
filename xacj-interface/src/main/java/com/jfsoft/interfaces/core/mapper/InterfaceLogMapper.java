package com.jfsoft.interfaces.core.mapper;

import com.jfsoft.interfaces.core.entity.InterfaceLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 接口日志表 Mapper 接口
 * </p>
 *
 * @author chenxc
 * @since 2020-03-30
 */
@Mapper
public interface InterfaceLogMapper extends BaseMapper<InterfaceLog> {

    /**
     * 获取日志列表 SqlServer
     *
     * @param params
     * @return
     */
    List<InterfaceLog> listSqlServer(Map<String, Object> params);

    /**
     * 获取日志列表总数 SqlServer
     *
     * @param params
     * @return
     */
    Integer countSqlServer(Map<String, Object> params);

    /**
     * 获取日志列表 Mysql
     *
     * @param params
     * @return
     */
    List<InterfaceLog> listMysql(Map<String, Object> params);

    /**
     * 获取日志列表总数 Mysql
     *
     * @param params
     * @return
     */
    Integer countMysql(Map<String, Object> params);

    /**
     * 获取日志列表 Mysql
     *
     * @param params
     * @return
     */
    List<InterfaceLog> listOracle(Map<String, Object> params);

    /**
     * 获取日志列表总数 Mysql
     *
     * @param params
     * @return
     */
    Integer countOracle(Map<String, Object> params);
}
