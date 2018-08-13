package com.nonegger.platform.smallroutine.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 请求第三方报文
 *
 * @author Eric
 * @date 2018/6/13 19:24
 */
@Data
public class TransData implements Serializable {
    private Long uid;// 用户登录id
    private String mobile;//手机号
    private String userName; //姓名
    private String idCard; // 身份证号

    private String version; // 固定1.0
    private String msgId; // 消息类型 0200
    private String transCode; // 交易代码 短信验证码：999100 签约：300009 消费：180002
    private String cardNo; // 卡号或token号
    private String expiryDate; // 卡片有效期 格式：YYMM
    private String merNo; // 商户号
    private String termNo; // 终端号 交行卡中心为商户分配的8位终端编号 居然是自定义，固定唯一
    private String traceNo; // 流水号 商户自定义6位流水号(可重复提交)

    // 签约短信接口不传 签约接口时传0 支付短信和支付时需要
    private String amount; // 金额 单位：分

    private String invioceNo; // 票据号 6位批次号+6位凭证号 TODO
    private String addDataField; // 附加字段 用途交易码：为哪类交易获取短信验证码。 110101表示快捷消费。110401快捷签约。
    private String addData; //附加域
    // 签约短信：00(数字0)+W+N+LL+客户姓名（最大长度不超过 10个字节(客户姓名可包含中文、英文、数字随意组合))+M+LL+商户名称（最大长度不超过40字节）+T+手机号(11)+ D+LL+4字节的证件类型+证件号
    // 00WN06测试12M08连连支付T13854515011
    // 支付短信：00(数字0)+W+N+LL+客户姓名（最大长度不超过 50个字节(客户姓名可包含中文、英文、数字随意组合))+M+LL+商户名称（最大长度不超过40字节）
    // 00WN09网易test2M20杭州卷瓜网络有限公司
    //LL表示长度，不足前补0(数字0)

    //签约接口字段

    //消费接口
    private String customData;//自定义域


}
