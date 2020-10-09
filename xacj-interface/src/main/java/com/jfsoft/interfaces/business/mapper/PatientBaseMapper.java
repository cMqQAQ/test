package com.jfsoft.interfaces.business.mapper;

import com.jfsoft.interfaces.business.entity.PatientBase;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author chenxc
 * @since 2020-09-25
 */

@Mapper
public interface PatientBaseMapper extends BaseMapper<PatientBase> {

}
