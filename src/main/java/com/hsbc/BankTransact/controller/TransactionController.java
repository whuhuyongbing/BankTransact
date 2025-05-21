package com.hsbc.BankTransact.controller;

import static com.hsbc.BankTransact.constant.ErrorCode.SUCCESS;
import static com.hsbc.BankTransact.constant.ErrorCode.SYSTEM_ERROR_RETRY_LATER;
import static com.hsbc.BankTransact.controller.model.CommonResponse.toCommonResponse;
import static com.hsbc.BankTransact.controller.model.CreateTransactionResponse.toCreateTransactionRes;
import static com.hsbc.BankTransact.controller.model.GetAllTransactionsRes.toGetAllTransactionsRes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hsbc.BankTransact.controller.model.CommonResponse;
import com.hsbc.BankTransact.controller.model.CreateTransactionResponse;
import com.hsbc.BankTransact.controller.model.GetAllTransactionsRes;
import com.hsbc.BankTransact.exception.BizException;
import com.hsbc.BankTransact.model.Transaction;
import com.hsbc.BankTransact.service.TransactionService;

/**
 * @author huyongbing
 * Created on 2025-05-20
 */

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;


    @PostMapping("/create")
    public CreateTransactionResponse createTransaction(@RequestBody Transaction request) {
        try {
            Transaction transaction = transactionService.createTransaction(request);
            return toCreateTransactionRes(transaction);
        } catch (BizException e) {
            return toCreateTransactionRes(e.getErrorCode());
        } catch (Exception e) {
            return toCreateTransactionRes(SYSTEM_ERROR_RETRY_LATER);
        }
    }

    @PutMapping("/{transactionId}")
    public CommonResponse updateTransaction(
            @RequestBody Transaction transaction) {
        try {
            transactionService.updateTransaction(transaction);
            return toCommonResponse(SUCCESS);
        } catch (BizException e) {
            return toCommonResponse(e.getErrorCode());
        } catch (Exception e) {
            return toCommonResponse(SYSTEM_ERROR_RETRY_LATER);
        }
    }

    @DeleteMapping("/{transactionId}")
    public CommonResponse deleteTransaction(@PathVariable String transactionId) {
        try {
            transactionService.deleteTransaction(transactionId);
            return toCommonResponse(SUCCESS);
        } catch (BizException e) {
            return toCommonResponse(e.getErrorCode());
        } catch (Exception e) {
            return toCommonResponse(SYSTEM_ERROR_RETRY_LATER);
        }
    }


    @GetMapping("/all")
    public GetAllTransactionsRes getAllTransactions(
            @RequestParam String uid,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        try {
            List<Transaction> transactions = transactionService.getAllTransactions(uid, page, size);
            return toGetAllTransactionsRes(transactions);
        } catch (BizException e) {
            return toGetAllTransactionsRes(e.getErrorCode());
        } catch (Exception e) {
            return toGetAllTransactionsRes(SYSTEM_ERROR_RETRY_LATER);
        }
    }
}
