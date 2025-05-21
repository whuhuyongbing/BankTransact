package com.hsbc.BankTransact.controller.model;

import static com.hsbc.BankTransact.constant.ErrorCode.SUCCESS;

import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.annotations.SerializedName;
import com.hsbc.BankTransact.constant.ErrorCode;
import com.hsbc.BankTransact.model.Transaction;

/**
 * @author huyongbing
 * Created on 2025-05-20
 */
public class GetAllTransactionsRes extends CommonResponse {

    @SerializedName("transactions")
    private List<TransactionVO> transactions;


    public List<TransactionVO> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionVO> transactions) {
        this.transactions = transactions;
    }

    public static GetAllTransactionsRes toGetAllTransactionsRes(List<Transaction> transactions) {
        GetAllTransactionsRes res = new GetAllTransactionsRes();
        res.setCode(SUCCESS.name());
        res.setCode(SUCCESS.getMsg());
        List<TransactionVO> transactionVOList = transactions.stream()
                .map(TransactionVO::toTransactionVO)
                .collect(Collectors.toList());
        res.setTransactions(transactionVOList);
        return res;
    }

    public static GetAllTransactionsRes toGetAllTransactionsRes(ErrorCode errorCode) {
        GetAllTransactionsRes res = new GetAllTransactionsRes();
        res.setCode(errorCode.name());
        res.setCode(errorCode.getMsg());
        return res;
    }
}
