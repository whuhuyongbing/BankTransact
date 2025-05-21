package com.hsbc.BankTransact.controller.model;

import com.google.gson.annotations.SerializedName;
import com.hsbc.BankTransact.constant.ErrorCode;

/**
 * @author huyongbing
 * Created on 2025-05-20
 */
public class CommonResponse {

    @SerializedName("code")
    private String code;

    @SerializedName("msg")
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static CommonResponse toCommonResponse(ErrorCode errorCode) {
        CommonResponse commonResponse = new CommonResponse();
        commonResponse.setCode(errorCode.name());
        commonResponse.setMsg(errorCode.getMsg());
        return commonResponse;
    }
}
