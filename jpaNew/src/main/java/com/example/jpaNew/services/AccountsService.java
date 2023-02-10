package com.example.jpaNew.services;

import com.example.jpaNew.entities.Accounts;
import com.example.jpaNew.entities.Statement;
import com.example.jpaNew.repositories.AccountsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountsService {
    private final AccountsRepository accountsRepository;

    public AccountsService(AccountsRepository accountsRepository) {
        this.accountsRepository = accountsRepository;
    }

    public List<Accounts> getAll() {

        List<Accounts> all= accountsRepository.findAll();
        return all;
    }

    public Optional<Accounts> getById(Long id) {

        Optional<Accounts> byId= accountsRepository.findById(id);
        return byId;
    }

    public Accounts getByIdGreaterThanEqualAndIdLessThanEqual(Long startId, Long endId) {

        Accounts byId= accountsRepository.getByIdGreaterThanEqualAndIdLessThanEqual(startId,endId);
        return byId;


    }

    public Accounts save(Accounts accounts) {
        final String methodName = "save() : ";
        System.out.println(methodName + "called");

        Accounts byId= accountsRepository.save(accounts);
        return byId;
    }

    public void deleteById(Long id) {

        accountsRepository.deleteById(id);
    }

    public Accounts getByAccountNo(String accountNo){
        return accountsRepository.findByAccountNo(accountNo);
    }


}
