package com.hsbc.BankTransact.constant;

/**
 * @author huyongbing
 * Created on 2025-05-20
 */
public enum ErrorCode {
    TRANSACTION_NOT_EXIST("Transaction does not exist, please check."),

    SYSTEM_ERROR_RETRY_LATER("System error, please retry later."),

    SUCCESS("Success"),
    UID_EMPTY("UID is empty."),
    AMOUNT_INVALID("Amount is invalid."),
    CURRENCY_INVALID("Currency is invalid."),
    TRANSACTION_TYPE_INVALID("Transaction type is invalid."),
    TRANSACTION_CATEGORY_INVALID("Transaction category is invalid."),
    DESCRIPTION_EMPTY("Description is empty."),
    TRANSACTION_ID_EMPTY("Transaction ID is empty.");


    private final String msg;


    ErrorCode(String msg) {
        this.msg = msg;
    }


    public String getMsg() {
        return msg;
    }
}
