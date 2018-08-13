package com.nonegger.platform.smallroutine.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;

/**
 * @author nonegge
 * @date 2017/10/26 10:15
 */
public class Sha1Utils {
    private static final Logger logger = LoggerFactory.getLogger(Sha1Utils.class);
    /**
     * SHA1 安全加密算法
     * @param decrypt 参数key-value map集合
     * @return
     */
    public static String SHA1(String decrypt){
        try {
            //指定sha1算法
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(decrypt.getBytes());
            //获取字节数组
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();

        } catch (Exception e) {
            logger.warn("sha1 failed. {}", e.getMessage());
        }
        return null;
    }
}
