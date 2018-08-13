package com.nonegger.platform.smallroutine.model;

import lombok.Data;

import java.io.Serializable;

/**
 * Project: platform-small-routine
 * Author : Eric
 * Time   : 2018/6/28 10:34
 * Desc   :  *
 */
@Data
public class BocomRespVO implements Serializable {
    private String version; // 固定1.0
    private String cardNo; // 卡号或token号
    private String returnCode; // 返回码
    private String hostDate; // 格式：yyyyMMdd
    private String hostTime; // 格式:HHmmss
    private String authNo; // 授权号
    private String addData; //附加域
    private String addDataField; // 附加字段 用途交易码：为哪类交易获取短信验证码。 110101表示快捷消费。110401快捷签约。
}
