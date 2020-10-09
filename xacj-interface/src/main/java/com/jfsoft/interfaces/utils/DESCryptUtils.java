package com.jfsoft.interfaces.utils;

import com.jfsoft.interfaces.config.GlobalConfig;
import org.apache.commons.codec.digest.DigestUtils;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class DESCryptUtils {

    public static String decrypt(String encrypedStr) throws Exception {

        StringBuilder dynamicSb = new StringBuilder();
        dynamicSb.append(encrypedStr.substring(3, 11))
                .append(encrypedStr.substring(14, 22))
                .append(encrypedStr.substring(25, 33))
                .append(encrypedStr.substring(36, 44));
        //秘钥的动态部分
        String dynamicKey = dynamicSb.toString();
        //计算 DESKEY
        String DESKey = DigestUtils. md5Hex ( GlobalConfig.PREKEY + dynamicKey);
        //剔除秘钥的加密字符串
        StringBuilder entrySb = new StringBuilder();
        entrySb.append(encrypedStr.substring(0, 3))
                .append(encrypedStr.substring(11, 14))
                .append(encrypedStr.substring(22, 25))
                .append(encrypedStr.substring(33, 36))
                .append(encrypedStr.substring(44));
        //BASE64 转换，DES 解密，再 BASE64 转换输出
        byte[] decryptBytes = org.apache.commons.codec.binary.Base64.decodeBase64(entrySb.toString());
        Cipher cipher = null;//|NoPadding

            cipher = Cipher. getInstance ("DES/ECB/PKCS5Padding");
            cipher.init(Cipher. DECRYPT_MODE , new SecretKeySpec( getKey (DESKey), "DES"));
            byte[] decoded = cipher.doFinal(decryptBytes);
            byte[] sourceBytes = org.apache.commons.codec.binary.Base64.decodeBase64(new String(decoded, "UTF-8"));

            return new String(sourceBytes, "UTF-8");


    }
    public static byte[] getKey(String keyRule){
        Key key = null;
        byte[] keyByte = keyRule.getBytes();
        // 创建一个空的八位数组,默认情况下为 0
        byte[] byteTemp = new byte[8];
        // 将用户指定的规则转换成八位数组
        for (int i = 0; i < byteTemp.length && i < keyByte.length; i++) {
            byteTemp[i] = keyByte[i];
        }
        key = new SecretKeySpec(byteTemp, "DES");
        return key.getEncoded();
    }
}
