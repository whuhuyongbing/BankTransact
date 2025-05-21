package com.hsbc.BankTransact.controller.model;

import com.google.gson.annotations.SerializedName;
import com.hsbc.BankTransact.model.Transaction;

/**
 * @author huyongbing
 * Created on 2025-05-20
 */
public class TransactionVO {
    @SerializedName("transactionId")
    private String transactionId;

    @SerializedName("uid")
    private String uid;

    @SerializedName("amount")
    private long amount;

    @SerializedName("currency")
    private String currency;

    @SerializedName("transactionType")
    private String transactionType;

    @SerializedName("transactionCategory")
    private String transactionCategory;

    @SerializedName("description")
    private String description;


    @SerializedName("createTime")
    private long createTime;


    @SerializedName("updateTime")
    private long updateTime;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionCategory() {
        return transactionCategory;
    }

    public void setTransactionCategory(String transactionCategory) {
        this.transactionCategory = transactionCategory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public static TransactionVO toTransactionVO(Transaction transaction) {
        TransactionVO transactionVO = new TransactionVO();
        transactionVO.setTransactionId(transaction.getTransactionId());
        transactionVO.setUid(transaction.getUid());
        transactionVO.setAmount(transaction.getAmount());
        transactionVO.setCurrency(transaction.getCurrency().getCurrencyCode());
        transactionVO.setTransactionType(transaction.getTransactionType().name());
        transactionVO.setTransactionCategory(transaction.getTransactionCategory().name());
        transactionVO.setDescription(transaction.getDescription());
        transactionVO.setCreateTime(transaction.getCreateTime());
        transactionVO.setUpdateTime(transaction.getUpdateTime());
        return transactionVO;
    }
}
