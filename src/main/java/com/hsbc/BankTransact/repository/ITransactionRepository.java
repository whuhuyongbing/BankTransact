package com.hsbc.BankTransact.repository;

import java.util.List;

import com.hsbc.BankTransact.model.Transaction;

/**
 * @author huyongbing
 * Created on 2025-05-20
 */
public interface ITransactionRepository {

    void save(Transaction transaction);

    void update(Transaction transaction);


    void delete(Transaction transaction);

    List<Transaction> queryAll(String uid, int page, int limit);

    Transaction query(String transactionId);

}
