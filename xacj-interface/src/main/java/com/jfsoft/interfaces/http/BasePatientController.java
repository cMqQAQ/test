package com.jfsoft.interfaces.http;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jfsoft.interfaces.business.entity.PatientBase;
import com.jfsoft.interfaces.business.entity.QRCode;
import com.jfsoft.interfaces.business.mapper.PatientBaseMapper;
import com.jfsoft.interfaces.utils.QRCodeUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.security.x509.OtherName;

import java.net.URLDecoder;
import java.util.List;

@RestController
@Slf4j
public class BasePatientController {

    @Autowired
    private PatientBaseMapper patientBaseMapper;

    @PostMapping("/cardno")
    public String getPid(@RequestBody String dataStr){
        dataStr= URLDecoder.decode(dataStr);
        dataStr= dataStr.replaceAll(" ","+");
        log.info("二维码加密字符串------" + dataStr);
        QRCode qrCode = null;
        try {
            qrCode = QRCodeUtil.readQRCode(dataStr);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("二维码字符串解析失败", e.getMessage());
        }
        log.info("二维码解密字符串------" + qrCode.toString());
        QueryWrapper<PatientBase> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("caseid", qrCode.getM());
        List<PatientBase> patientBases = patientBaseMapper.selectList(queryWrapper);
        if (null == patientBases)
            return "";

        return patientBases.get(0).getPid();
    }
}
