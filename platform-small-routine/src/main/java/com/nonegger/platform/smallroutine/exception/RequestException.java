package com.nonegger.platform.smallroutine.exception;

/**
 * Created by liuguodong01 on 2017/7/19.
 */
public class RequestException extends RuntimeException {


    public RequestException(Long code, String message) {
        super(message);
        this.code = code;
    }

    public RequestException(Long code, String message, String showMsg) {
        super(message);
        this.code = code;
        this.showMsg = showMsg;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    private Long code;

    private String showMsg;

    public String getShowMsg() {
        return showMsg;
    }

    public void setShowMsg(String showMsg) {
        this.showMsg = showMsg;
    }

}
