package com.nonegger.platform.smallroutine.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by nonegger on 2017/7/19.
 */
public class SignUtils {
    private static final Logger logger = LoggerFactory.getLogger(SignUtils.class);

    /**
     * @Author: nonegger, nonegger@163.com
     * @Param: * @param null
     * @Description: 仅排序计算 sign 值, 不参与计算的参数, 由业务在传入前自行剔除, 如果遇到多个参数仅处理其中第一个
     * 签名方式:  按 key 字母排序, 生成 md5(key1=value1&key2=value2...&token=xxx)
     * @Date: 上午11:44 2017/7/20
     */
    public static String sign(Map<String, String> paramMap, String token) {
        List<Map.Entry<String, String>> paramsList = new ArrayList<>(paramMap.entrySet());
        try {
            TreeMap<String, String> params = new TreeMap<>(paramMap);
            StringBuilder sb = new StringBuilder();
            params.forEach((k, v) -> sb.append(k).append("=").append(v).append("&"));
            sb.append("token=").append(token);
            logger.info("业务方待签名串：[{}]", sb.toString());
            return Md5Utils.GetMD5Code(sb.toString());
            //Collections.sort(paramsList, new Comparator<Map.Entry<String, String>>() {
            //    @Override
            //    public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
            //        return o1.getKey().compareTo(o2.getKey());
            //    }
            //});
            //List<String> params = new ArrayList<>();
            //for (Map.Entry<String, String> singleOne: paramsList) {
            //    params.add(String.format("%s=%s", singleOne.getKey(), singleOne.getValue()));
            //}
            //params.add("token=" + token);
            //
            //String orignalSign = StringUtils.join(params, "&");
            //logger.info("业务方待签名串：[{}]", orignalSign);
            //return Md5Utils.GetMD5Code(orignalSign);
        } catch (Exception e) {
            logger.warn("parameter sort failed. {}", e.getMessage());
        }
        return null;
    }

    public static String getAccountSign(Map<String, String> paramMap, String appkey) {
        List<Map.Entry<String, String>> paramsList = new ArrayList<>(paramMap.entrySet());
        try {
            Collections.sort(paramsList, new Comparator<Map.Entry<String, String>>() {
                @Override
                public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                    return o1.getKey().compareTo(o2.getKey());
                }
            });
            List<String> params = new ArrayList<>();
            for (Map.Entry<String, String> singleOne : paramsList) {
                params.add(String.format("%s=%s", singleOne.getKey(), singleOne.getValue()));
            }
            params.add(appkey);

            String orignalSign = StringUtils.join(params, "&");
            return md5sum(orignalSign);
        } catch (Exception e) {
            logger.warn("parameter sort failed. {}", e.getMessage());
        }
        return null;
    }

    public static String md5sum(String message) {
        return Md5Utils.GetMD5Code(message);
    }

    public static String getSha1Sign(Map<String, String> paramMap) {
        List<Map.Entry<String, String>> paramsList = new ArrayList<>(paramMap.entrySet());
        try {
            Collections.sort(paramsList, new Comparator<Map.Entry<String, String>>() {
                @Override
                public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
                    return o1.getKey().compareTo(o2.getKey());
                }
            });
            List<String> params = new ArrayList<>();
            for (Map.Entry<String, String> singleOne : paramsList) {
                params.add(String.format("%s=%s", singleOne.getKey(), singleOne.getValue()));
            }

            String orignalSign = StringUtils.join(params, "&");
            return Sha1Utils.SHA1(orignalSign);
        } catch (Exception e) {
            logger.warn("parameter sort failed. {}", e.getMessage());
        }
        return null;
    }
}
