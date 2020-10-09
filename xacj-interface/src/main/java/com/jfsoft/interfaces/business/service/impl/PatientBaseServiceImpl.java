package com.jfsoft.interfaces.business.service.impl;

import com.jfsoft.interfaces.business.entity.PatientBase;
import com.jfsoft.interfaces.business.mapper.PatientBaseMapper;
import com.jfsoft.interfaces.business.service.IPatientBaseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chenxc
 * @since 2020-09-25
 */
@Service
public class PatientBaseServiceImpl extends ServiceImpl<PatientBaseMapper, PatientBase> implements IPatientBaseService {

}
