package com.hsbc.BankTransact.exception;

import com.hsbc.BankTransact.constant.ErrorCode;

/**
 * @author huyongbing
 * Created on 2025-05-20
 */
public class BizException extends RuntimeException {
    private ErrorCode errorCode;

    public BizException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public static BizException of(ErrorCode code) {
        return new BizException(code);
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
