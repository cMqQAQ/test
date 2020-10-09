package com.jfsoft.interfaces.utils;

import com.jfsoft.interfaces.business.entity.QRCode;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class QRCodeUtil {

    public static QRCode readQRCode(String qrStr) throws Exception {
        String dataStr = qrStr.substring(0, qrStr.length()-5);


        return com.alibaba.fastjson.JSON.parseObject(DESCryptUtils.decrypt(dataStr), QRCode.class);


    }

}
