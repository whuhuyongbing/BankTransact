package com.hsbc.BankTransact.controller.model;

import static com.hsbc.BankTransact.constant.ErrorCode.SUCCESS;

import com.google.gson.annotations.SerializedName;
import com.hsbc.BankTransact.constant.ErrorCode;
import com.hsbc.BankTransact.model.Transaction;
/**
 * @author huyongbing
 * Created on 2025-05-20
 */
public class CreateTransactionResponse extends CommonResponse {


    @SerializedName("transaction")
    private TransactionVO transactionVO;

    public TransactionVO getTransactionVO() {
        return transactionVO;
    }

    public void setTransactionVO(TransactionVO transactionVO) {
        this.transactionVO = transactionVO;
    }

    public static CreateTransactionResponse toCreateTransactionRes(Transaction transaction) {
        CreateTransactionResponse response = new CreateTransactionResponse();
        response.setCode(SUCCESS.name());
        response.setMsg(SUCCESS.getMsg());
        response.setTransactionVO(TransactionVO.toTransactionVO(transaction));
        return response;
    }

    public static CreateTransactionResponse toCreateTransactionRes(ErrorCode errorCode) {
        CreateTransactionResponse response = new CreateTransactionResponse();
        response.setCode(errorCode.name());
        response.setMsg(errorCode.getMsg());
        return response;
    }
}
