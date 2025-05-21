package com.hsbc.BankTransact.service;

import java.util.List;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.hsbc.BankTransact.constant.ErrorCode;
import com.hsbc.BankTransact.exception.BizException;
import com.hsbc.BankTransact.exception.ParamException;
import com.hsbc.BankTransact.model.Transaction;
import com.hsbc.BankTransact.repository.MemoryTransactionRepository;
import com.hsbc.BankTransact.util.TransactionIdGenerator;

/**
 * @author huyongbing
 * Created on 2025-05-20
 */

@Lazy
@Service
public class TransactionService implements ITransactionService {

    @Autowired
    private MemoryTransactionRepository transactionRepository;

    @Override
    public Transaction createTransaction(Transaction transaction) {
        validateCreateTransaction(transaction);

        initTransaction(transaction);

        transactionRepository.save(transaction);

        return transaction;
    }


    @Override
    public void updateTransaction(Transaction transaction) {
        validateUpdateTransaction(transaction);

        Transaction transactionInDB = transactionRepository.query(transaction.getTransactionId());

        if (transactionInDB == null) {
            throw BizException.of(ErrorCode.TRANSACTION_NOT_EXIST);
        }
        updateTransactionInMemory(transaction, transactionInDB);
        transactionRepository.update(transactionInDB);
    }

    @Override
    public void deleteTransaction(String transactionId) {
        Transaction transactionIdDB = transactionRepository.query(transactionId);

        if (transactionIdDB == null) {
            throw BizException.of(ErrorCode.TRANSACTION_NOT_EXIST);
        }

        transactionRepository.delete(transactionIdDB);
    }


    @Override
    public List<Transaction> getAllTransactions(String uid, int page, int size) {
        return transactionRepository.queryAll(uid, page, size);
    }

    private void validateCreateTransaction(Transaction transaction) {
        commonValidate(transaction);
    }

    private void commonValidate(Transaction transaction) {
        if (Strings.isEmpty(transaction.getUid())) {
            throw ParamException.of(ErrorCode.UID_EMPTY);
        }

        if (transaction.getAmount() <= 0) {
            throw ParamException.of(ErrorCode.AMOUNT_INVALID);
        }

        if (transaction.getCurrency() == null) {
            throw ParamException.of(ErrorCode.CURRENCY_INVALID);
        }

        if (transaction.getTransactionType() == null) {
            throw ParamException.of(ErrorCode.TRANSACTION_TYPE_INVALID);
        }

        if (transaction.getTransactionCategory() == null) {
            throw ParamException.of(ErrorCode.TRANSACTION_CATEGORY_INVALID);
        }

        if (Strings.isEmpty(transaction.getDescription())) {
            throw ParamException.of(ErrorCode.DESCRIPTION_EMPTY);
        }
    }

    private void initTransaction(Transaction transaction) {
        transaction.setTransactionId(TransactionIdGenerator.generateId());
        transaction.setCreateTime(System.currentTimeMillis());
        transaction.setUpdateTime(System.currentTimeMillis());
    }

    private void updateTransactionInMemory(Transaction transaction, Transaction transactionInDB) {
        transactionInDB.setAmount(transaction.getAmount());
        transactionInDB.setCurrency(transaction.getCurrency());
        transactionInDB.setTransactionType(transaction.getTransactionType());
        transactionInDB.setTransactionCategory(transaction.getTransactionCategory());
        transactionInDB.setDescription(transaction.getDescription());
        transactionInDB.setUpdateTime(System.currentTimeMillis());
    }

    private void validateUpdateTransaction(Transaction transaction) {
        commonValidate(transaction);
        if (Strings.isEmpty(transaction.getTransactionId())) {
            throw ParamException.of(ErrorCode.TRANSACTION_ID_EMPTY);
        }
    }
}
