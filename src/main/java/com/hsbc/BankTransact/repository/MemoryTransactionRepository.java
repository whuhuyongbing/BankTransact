package com.hsbc.BankTransact.repository;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.hsbc.BankTransact.model.Transaction;

/**
 * @author huyongbing
 * Created on 2025-05-20
 */
@Lazy
@Service
public class MemoryTransactionRepository implements ITransactionRepository {

    private final Map<String, Transaction> transactionMap = new ConcurrentHashMap<>();

    @Override
    public void save(Transaction transaction) {
        transactionMap.put(transaction.getUid(), transaction);
    }

    @Override
    public void update(Transaction transaction) {
        if (!transactionMap.containsKey(transaction.getTransactionId())) {
            return;
        }

        transactionMap.put(transaction.getTransactionId(), transaction);
    }

    @Override
    public void delete(Transaction transaction) {
        transactionMap.remove(transaction.getTransactionId());
    }

    @Override
    public List<Transaction> queryAll(String uid, int page, int limit) {
        return transactionMap.values().stream()
                .filter(tx -> uid.equals(tx.getUid()))
                .skip((long) page * limit)
                .limit(limit)
                .collect(Collectors.toList());
    }

    @Override
    public Transaction query(String transactionId) {
        return transactionMap.get(transactionId);
    }
}
