package com.nonegger.platform.smallroutine.exception;

/**
 * Project: payplatform-pay
 * Author : chris ran
 * Time   : 2017/7/19
 * Desc   : 异常码集合
 */

public enum ExceptionEnum {

    SUCCESS(0L, "SUCCESS"),
    SIGN_ERROR(8004010001L, "SIGN_ERROR"),
    MISSING_CUSTOMERID(8004010002L, "MISSING_CUSTOMERID"),
    MISSING_PARAMS(8004010003L, "MISSING_PARAMS"),
    INTERNAL_ERROR(8004010004L, "INTERNAL_ERROR"),
    MISSING_TIMESTAMP(8004010005L, "MISSING_TIMESTAMP"),
    AUTH_RESPONSE_FAIL(800401006L, "auth response fail", "账户异常，请重新登录"),
    USER_NOT_LOGIN(800401007L, "user not login", "账户异常，请重新登录"),
    USER_NOT_VALID(800401008L, "user not valid"),

    TIME_PARAM_ERROR(80040100010L, "time format error", "请求已过期"),
    CUSTOMER_NOT_VALID(8004010011L, "CUSTOMER_NOT_VALID"),
    CHANNEL_REQUEST_ERROR(800401012L, "channel request failed"),
    PAYCHANNEL_NOT_FOUND(8004010013L, "pay channel not found"),
    PAYCHANNEL_NOT_SUPPORT(8004010014L, "pay channel not support"),
    REQUEST_FREQUENTLY_ERROR(8004010015L, "request frequently"),
    RETURN_URL_NOT_FOUND(8004010016L, "return url not found"),
    PAYCHANNELRULE_ERROR(8004010017L, "pay channel rule error"),
    FEE_TYPE_NOT_SUPPORT(8004010016L, "feeType or currencyFeeType not support","货币类型不支持"),


    WX_RESP_CHECKSUM_FAILED(8004010021L, "WX_RESP_CHECKSUM_FAILED"),
    WX_RESP_RETURN_FAILED(8004010022L, "WX_RESP_RETURN_FAILED"),
    WX_RESP_PARAM_FAILED(8004010023L, "WX_RESP_PARAM_FAILED"),
    //qpay返回错误
    QPAY_RESP_PARAM_FAILED(8004010024L, "QPAY_RESP_PARAM_FAILED"),

    //订单相关
    CREATE_PAY_ORDER_FAIL(8004010031L, "create pay order fail"),
    CREATE_WECHAT_ORDER_FAIL(8004010032L, "create wechat order fail"),
    CREATE_WECHAT_QRCODE_FAIL(8004010033L, "create wechat qrcode fail"),
    CREATE_WECHAT_H5URL_FAIL(8004010034L, "create h5 url fail"),
    CREATE_WECHAT_APP_FAIL(8004010035L, "create app param fail"),
    CREATE_WECHAT_H5_IP(8004010036L, "wechat h5 must need ip"),
    CREATE_WECHAT_JSAPI_OPENID(8004010037L, "wechat jsapi must need openid"),
    CREATE_WECHAT_JSAPI_FAIL(8004010038L, "create jsapi param fail"),

    CREATE_QPAY_ORDER_FAIL(8004010090L, "create qpay order fail"),
    CREATE_QPAY_QRCODE_FAIL(8004010091L, "create qpay qrcode fail"),
    CREATE_QPAY_H5URL_FAIL(8004010092L, "create qpay h5 url fail"),
    CREATE_QPAY_APP_FAIL(8004010093L, "create qpay app param fail"),
    CREATE_QPAY_H5_IP(8004010094L, "qpay h5 must need ip"),
    CREATE_QPAY_JSAPI_OPENID(8004010095L, "qpay jsapi must need openid"),
    CREATE_QPAY_JSAPI_FAIL(8004010096L, "create qpay jsapi param fail"),

    REQUEST_PAY_FAIL(8004010041L, "request pay fail"),
    BUILD_WECHAT_INSTANCE(8004010042L, "build wechat instance fail"),
    BUILD_ALIPAY_INSTANCE(8004010043L, "build alipay instance fail"),
    BUILD_QPAY_INSTANCE(80040100421L, "build qpay instance fail"),
    BUILD_ALIPAY_PARAM_FAIL(8004010044L, "build alipay param fail"),
    ORDER_STATUS_INCORRECT(8004010045L, "order status incorrect", "订单状态异常"),
    ORDER_ALREADY_PAY(8004010046L, "order already pay", "订单已支付，请勿重复支付"),
    THIRD_DATA_ERROR(8004010047L, "third data error"),
    GOOGLEPAY_DATA_ERROR(8004010048L, "google pay data error"),
    WECHAT_ACCESS_ERROR(8004010049L, "wechat access pay data error"),
    WECHAT_UNIORDER_FAIL(8004010050L, "微信统一下单失败"),

    //回调
    WECHAT_PAYNOTIFY_REPEAT_NOTIFY(8004010051L, "wechat repeat notify"),
    WECHAT_PAYNOTIFY_REPEAT_PAY(8004010052L, "wechat repeat pay"),
    WECHAT_PAYNOTIFY_HANDLE_ERROR(8004010053L, "wechat pay notify handle error"),
    WECHAT_PAYNOTIFY_AMOUNT_ERROR(8004010054L, "wechat pay notify amount error"),
    WECHAT_PAYNOTIFY_APPID_ERROR(8004010055L, "wechat pay notify appid error"),
    WECHAT_PAYNOTIFY_SIGN_ERROR(8004010056L, "wechat pay notify sign error"),
    WECHAT_PAYNOTIFY_STATUS_ERROR(8004010057L, "wechat pay notify status error"),


    ALIPAY_PAYNOTIFY_REPEAT_NOTIFY(8004010061L, "alipay repeat notify"),
    ALIPAY_PAYNOTIFY_REPEAT_PAY(8004010062L, "alipay repeat pay"),
    ALIPAY_PAYNOTIFY_HANDLE_ERROR(8004010063L, "alipay pay notify handle error"),
    ALIPAY_PAYNOTIFY_AMOUNT_ERROR(8004010064L, "alipay pay notify amount error"),
    ALIPAY_PAYNOTIFY_APPID_ERROR(8004010065L, "alipay pay notify appid error"),
    ALIPAY_PAYNOTIFY_SIGN_ERROR(8004010066L, "alipay pay notify sign error"),
    ALIPAY_PAYNOTIFY_STATUS_ERROR(8004010067L, "alipay pay notify status error"),
    ALIPAY_GLOBAL_PAYNOTIFY_SIGN_ERROR(8004010068L, "alipay global pay notify sign error"),

    PAYNOTIFY_REPEAT_NOTIFY(8004010071L, "repeat notify"),

    PAYNOTIFY_STATUS_ERROR(8004110067L, "pay notify status error"),

    PAY_NOTIFY_HANDLED(8004010071L, "pay notify handled"),
    SYS_REQUEST_REFUND_FAIL(8004010072L, "system refund fail"),
    PAY_NOTIFY_CUSTOMER_FAIL(8004010073L, "pay notify customer fail"),
    ORDER_REPEAT_RECORD_INSERT_FAIL(8004010074L, "insert order repeat fail"),
    ORDER_UPDATE_FAIL(8004010075L, "order update fail"),


    GOOGLE_PAY_SIGN_ERROR(8004010081L, "google pay sign fail"),

    IAP_RECEIPT_RESUE_ERROR(8004010091L, "iap receipt can not reuse"),
    IAP_RETRY(8004010092L, "iap retry"),
    IAP_RECEIPT_USE_ERROR(8004010093L, "iap receipt can not use"),
    IAP_SANDBOX_MID_ERROR(8004010094L, "iap sandbox not contain this user"),
    IAP_RECEIPT_NOT_EXISTS(8004010095L, "iap receipt not exists"),
    IAP_NOTIFY_RETRY_ERROR(8004010096L, "iap notify retry error"),
    IAP_IN_SUBSCRIBE(8004010097L, "iap in subscription", "订阅期间不可购买"),

    DEVICE_TYPE_NOT_SUPPORT(8004010100L, "not supported device"),
    NO_UNPAY_ORDER_FOUND(8004010101L, "NO_UNPAY_ORDER_FOUND"),

    // 退款相关
    NO_PAY_ORDER_FOUND(8004010201L, "NO_PAY_ORDER_FOUND"),
    NO_PAY_ORDER_ACCESS_RIGHT(8004010202L, "NO_PAY_ORDER_FOUND"),
    REFUND_HAS_PROCESSING(800401206L, "total amount refund has in processing, please hold"),
    REFUND_NOT_PERMITTED(800401207L, "can not refund right now"),
    REFUND_RECORD_NOT_FIND(8004010208L, "REFUND_NOT_FIND"),
    CHANNEL_REFUND_NOT_SUPPORT_YET(8004010209L, "CHANNEL_NOT_SUPPORT_YET"),
    CHANNEL_PARAM_NOT_EQUAL(8004010210L, "CHANNEL_PARAM_NOT_EQUAL_WHICH_CAN_BE_CONSIDER_AS_INTERNAL_ERROR"),
    CHANNEL_REFUND_NO_CHANNEL_FOUND(8004010211L, "REFUND_BUT_NO_PAY_CHANNEL_FOUND"),
    BATCH_REFUND_NOT_PERMITTED(8004010212L, "BATCH_REFUND_NO_PERMITTED"),
    BATCH_REFUND_FAIL_AMOUNT_MISMATCH(8004010212L, "fail refund should use the same amount"),
    CHANNEL_REFUND_QUERY_BAD_STATUS(8004010213L, "channel refund query has a unrecognized status"),
    ORDER_HAS_NO_REFUND_RECORD(8004010214L, "order has no refund record"),
    OVER_REFUND_AMOUNT(8004010215L, "refund amount more than paid"),
    TOTAL_REFUND_AMOUNT_MISMATCH(8004010216L, "total refund amount should equal with paid amount"),
    REFUND_FAILED(8004010216L, "refund failed, please use same customer refund id to refund again"),
    CHANNEL_REFUND_FAILED(8004010217L, "channel refund failed"),
    BATCH_REFUND_IS_PROCESSING(8004010218L, "batch refund is processing, can not create total refund."),
    NO_BATCH_REFUND_FOUND(8004010219L, "no batch refund found."),
    REFUND_DONE(800401221L, "total refund success, not allowed to do agagin"),
    BATCH_REFUND_DONE(800401222L, "batch refund success, not allowed to do agagin"),
    TOTAL_AMOUNT_NOT_EQUAL(800401223L, "total amount not equal with pay amount"),
    CHANNEL_ORDERNO_NOT_EXISTS(800401224L, "channel orderno not exists"),

    ALIPAY_PAY_REFUND_NOTIFY_HANDLER_ERROR(800401300L, "alipay pay refund notify handler error"),
    ALIPAY_PAY_REFUND_NOTIFY_AMOUNT_ERROR(800401301L, "alipay pay refund notify amount error"),
    ALIPAY_PAY_REFUND_PAYNOTIFY_APPID_ERROR(800401302L, "alipay pay refund notify appid error"),
    ALIPAY_PAY_REFUND_PAYNOTIFY_SIGN_ERROR(800401303L, "alipay pay refund notify sign error"),
    ALIPAY_PAY_REFUND_NOTIFY_STATUS_ERROR(800401304L, "alipay pay refund notify status error"),

    BP_IS_NOT_ENOUGH(800409904L, "B 币余额不足", "你的B币余额不足，需充值才可继续购买，现在就充值吗？"),

    // DB 操作相关
    DB_INSERT_FAILED(8004010512L, "db insert failed"),
    DB_UPDATE_FAILED(8004010513L, "db update failed"),
    DB_SELECT_FAILED(8004010514L, "db select failed"),


    // 结尾符
    END_FOR_QUOTE(8004010999L, "DO NOT MODIFY THIS LINE, NEVEL !!!"),

    WECHAT_CONTRACT_ORDER_ERROR(8004010514L, "weChat contract order error!"),

    WECHAT_APPLY_DEDUCTION_ERROR(8004010515L, "weChat apply deduction error!"),

    WECHAT_APPLY_DISMISS_ERROR(8004010516L, "weChat apply dismiss error!不存在签约记录!"),

    WECHAT_QUERY_CONTRACT_ERROR(8004010517L, "weChat query contract error!"),

    WECHAT_SIGN_NOTIFY_HANDLE_ERROR(8004010518L, "weChat sign notify handle error!"),

    WECHAT_WITHHOLD_AMOUNT_OVERFLOW(8004010519L, "weChat withhold amount overflow!"),

    TEST_TIME_OUT_ERROR(8999999999L, "testTimeoutError!");//TODO


    /**
     * 错误码
     */
    private Long code;
    /**
     * 错误信息
     */
    private String msg;

    private String showMsg;

    ExceptionEnum(Long code, String msg) {
        this(code, msg, COMMON_SHOW_ERROR_MSG);
    }

    ExceptionEnum(Long code, String msg, String showMsg) {
        this.code = code;
        this.msg = msg;
        this.showMsg = showMsg;
    }

    public Long getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public RequestException createException() {
        return new RequestException(this.code, this.msg, this.showMsg);
    }

    public RequestException createException(String msg) {
        return new RequestException(this.code, msg);
    }

    public final static String COMMON_SHOW_ERROR_MSG = "服务器开小差了";
}
