package com.example.jpaNew.controllers;

import com.example.jpaNew.entities.Transaction;
import com.example.jpaNew.repositories.TransactionRepository;
import com.example.jpaNew.services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/transaction")
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionService transactionService;

    @RequestMapping(method = RequestMethod.GET, value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAll() {
        List<Transaction> transactions = transactionRepository.findAll();
        if (transactions == null) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
        System.out.println("Number of transactions are " + transactions.size());
        return new ResponseEntity<>(transactions, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.GET, value = "/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getById(@PathVariable("id") long id) {
        Optional<Transaction> byId = transactionRepository.findById(id);
        if (!byId.isPresent()) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);

        }
        return new ResponseEntity<>(byId.get(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/amount/{amount}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getByAmount(@PathVariable("amount") Long amount) {
        if (amount == null || amount < 0) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        List<Transaction> transactionList = transactionRepository.findByAmount(amount);
        if (transactionList == null || transactionList.size() < 1) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
        return new ResponseEntity<>(transactionList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/amount/filter", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getByStartAmount(@RequestParam("startAmount") Long startAmount, @RequestParam("endAmount") Long endAmount) {
        if (startAmount == null || endAmount == null || startAmount < 0 || endAmount < 0) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }

        List<Transaction> transactionList = transactionRepository.findByAmountGreaterThanEqualAndAmountLessThanEqual(startAmount, endAmount);
        if (transactionList == null || transactionList.size() < 1) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
        return new ResponseEntity<>(transactionList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        Transaction transactionSaved = transactionRepository.save(transaction);
        return new ResponseEntity<>(transactionSaved, HttpStatus.CREATED);
    }


    @PutMapping("/transaction/{id}")
    public ResponseEntity<?> replaceTransaction(@RequestBody Transaction newTransaction, @PathVariable Long id) {

        Transaction transactionToUpdate = transactionRepository.findById(id).get();
        transactionToUpdate.setAmount(newTransaction.getAmount());
        Transaction updatedTransaction = transactionRepository.save(transactionToUpdate);
        return new ResponseEntity<>(updatedTransaction, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<Transaction> deleteById(@PathVariable("id") Long id) {

        if (id == null || id <= 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

          transactionRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}




