package com.teraboard.fintrax.controller;

import com.teraboard.fintrax.model.Transaction;
import com.teraboard.fintrax.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired // weird autowire false positive
    private TransactionService transactionService;

    @PostMapping
    public Transaction addTransaction(@RequestBody Transaction transaction) {
        return transactionService.saveTransaction(transaction);
    }

    @GetMapping
    public List<Transaction> getTransactions(@RequestParam Long userId) {
        return transactionService.getTransactionsByUserId(userId);
    }

}