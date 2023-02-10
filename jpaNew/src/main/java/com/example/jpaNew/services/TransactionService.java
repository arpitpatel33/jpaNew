package com.example.jpaNew.services;

import com.example.jpaNew.entities.Transaction;
import com.example.jpaNew.repositories.TestRepository;
import com.example.jpaNew.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    }
