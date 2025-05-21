package com.hsbc.BankTransact.exception;

import com.hsbc.BankTransact.constant.ErrorCode;

/**
 * @author huyongbing
 * Created on 2025-05-20
 */
public class ParamException extends BizException {

    public ParamException(ErrorCode errorCode) {
        super(errorCode);
    }

}
