package com.hsbc.BankTransact.service;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.hsbc.BankTransact.model.Transaction;
import com.hsbc.BankTransact.repository.MemoryTransactionRepository;

import static org.mockito.Mockito.*;

/**
 * @author huyongbing
 * Created on 2025-05-21
 */
class TransactionServiceTest {
    @Mock
    MemoryTransactionRepository transactionRepository;
    @InjectMocks
    TransactionService transactionService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateTransaction() {
        Transaction result = transactionService.createTransaction(new Transaction());
        Assertions.assertEquals(new Transaction(), result);
    }

    @Test
    void testUpdateTransaction() {
        when(transactionRepository.query(anyString())).thenReturn(new Transaction());

        transactionService.updateTransaction(new Transaction());
    }

    @Test
    void testDeleteTransaction() {
        when(transactionRepository.query(anyString())).thenReturn(new Transaction());

        transactionService.deleteTransaction("transactionId");
    }

    @Test
    void testGetAllTransactions() {
        when(transactionRepository.queryAll(anyString(), anyInt(), anyInt())).thenReturn(List.of(new Transaction()));

        List<Transaction> result = transactionService.getAllTransactions("uid", 0, 0);
        Assertions.assertEquals(List.of(new Transaction()), result);
    }
}