package com.jfsoft.interfaces.core.service.impl;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jfsoft.interfaces.core.entity.InterfaceLog;
import com.jfsoft.interfaces.core.entity.LogForm;
import com.jfsoft.interfaces.core.mapper.InterfaceLogMapper;
import com.jfsoft.interfaces.core.service.IInterfaceLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 接口日志表 服务实现类
 * </p>
 *
 * @author chenxc
 * @since 2020-03-30
 */
@Service
public class InterfaceLogServiceImpl extends ServiceImpl<InterfaceLogMapper, InterfaceLog> implements IInterfaceLogService {

    @Autowired
    InterfaceLogMapper interfaceLogMapper;

    @Value("${spring.datasource.dynamic.primary}")
    private String dbType;

    @Value("${app.module-code}")
    private String moduleCode;

    /**
     * 获取日志列表
     *
     * @param log
     * @return
     */
    @Override
    public List<InterfaceLog> list(LogForm log) {
        Map<String, Object> params = new HashMap<>(3);
        params.put("start", (log.getIndex() - 1) * log.getSize());
        params.put("end", log.getSize());
        params.put("beginTime", log.getBeginTime());
        params.put("endTime", log.getEndTime());
        params.put("status", log.getStatus());
        params.put("reqStr", log.getReqStr());
        params.put("rspStr", log.getRspStr());
        params.put("moduleCode", moduleCode);
        if (dbType.equalsIgnoreCase(DbType.SQL_SERVER.getDb())) {
            return interfaceLogMapper.listSqlServer(params);
        } else if (dbType.equalsIgnoreCase(DbType.MYSQL.getDb())) {
            return interfaceLogMapper.listMysql(params);
        } else if (dbType.equalsIgnoreCase(DbType.ORACLE.getDb())) {
            return interfaceLogMapper.listOracle(params);
        } else {
            return null;
        }
    }

    /**
     * 获取日志列表总数
     *
     * @param log
     */
    @Override
    public Integer count(LogForm log) {
        Map<String, Object> params = new HashMap<>();
        params.put("start", (log.getIndex() - 1) * log.getSize());
        params.put("end", log.getSize());
        params.put("beginTime", log.getBeginTime());
        params.put("endTime", log.getEndTime());
        params.put("status", log.getStatus());
        params.put("reqStr", log.getReqStr());
        params.put("rspStr", log.getRspStr());
        params.put("moduleCode", moduleCode);
        if (dbType.equalsIgnoreCase(DbType.SQL_SERVER.getDb())) {
            return interfaceLogMapper.countSqlServer(params);
        } else if (dbType.equalsIgnoreCase(DbType.MYSQL.getDb())) {
            return interfaceLogMapper.countMysql(params);
        } else if (dbType.equalsIgnoreCase(DbType.ORACLE.getDb())) {
            params.put("end", log.getIndex() * log.getSize());
            return interfaceLogMapper.countOracle(params);
        } else {
            return null;
        }
    }
}
