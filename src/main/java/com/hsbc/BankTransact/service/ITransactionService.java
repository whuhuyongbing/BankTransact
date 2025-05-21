package com.hsbc.BankTransact.service;

import java.util.List;

import com.hsbc.BankTransact.model.Transaction;

/**
 * @author huyongbing
 * Created on 2025-05-20
 */
public interface ITransactionService {

    Transaction createTransaction(Transaction transaction);


    void updateTransaction(Transaction transaction);

    void deleteTransaction(String uid);

    List<Transaction> getAllTransactions(String uid, int page, int size);
}
