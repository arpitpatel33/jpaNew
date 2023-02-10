package com.example.jpaNew.services;

import com.example.jpaNew.entities.Accounts;
import com.example.jpaNew.entities.Statement;
import com.example.jpaNew.repositories.AccountsRepository;
import com.example.jpaNew.repositories.StatementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StatementService {

    @Autowired
    private StatementRepository statementRepository;

    @Autowired
    private AccountsService accountsService;
    @Autowired
    private AccountsRepository accountsRepository;

    public List<Statement> getAll() {

        List<Statement> all= statementRepository.findAll();
        return all;
    }

    public Optional<Statement> getById(Long id) {

        Optional<Statement> byId= statementRepository.findById(id);
        return byId;
    }

    public List<Statement> getByIdGreaterThanEqualAndIdLessThanEqual(Long startId, Long endId) {

        List<Statement> byId= statementRepository.getByIdGreaterThanEqualAndIdLessThanEqual(startId,endId);

        return byId;
    }


    @Transactional
    public Statement processTransaction(Statement statement){
        final String methodName = "processTransaction() : ";
        System.out.println(methodName  + "called");
        //input statement is new statement to be created
        Statement insertedStatement = null;

        //step 1 check statement is valid or not
        //step 2 check account exists with account no available in statement
        //step 3 check which type of transaction it is credit or debit
        //step 4 if its of type debit then check balance whether is greater than the amount of debit
        //Step 5 in case of debit deduct balance from account and update Account object
        //Step 6 In case of credit add balance to account and update Account object
        //Step 7 in both cases if account is updated then insert this transaction/statement
        //Step 8 In case statement/transaction could not be saved due to technical error the update account should revert.
        if(statement!=null){
            String account_no = statement.getAccount_no();
            if(account_no!= null){

                Accounts account = accountsService.getByAccountNo(account_no);
                System.out.println(account);
                if(account!=null) {
                    System.out.println(account);


                    String statementType = statement.getType();


                    if(statementType != null){

                        if(statementType.equals("Credit")){

                            double balance = account.getBalance();

                            double creditAmount= statement.getAmount();

                            double newBalance = balance + creditAmount;

                            account.setBalance(newBalance);


                        }else if(statementType.equals("Debit")){

                            double balance= account.getBalance();
                            double debitAmount= statement.getAmount();

                            if(balance>debitAmount){

                                double newBalance = balance - debitAmount;

                                account.setBalance(newBalance);

                            }

                            Accounts accountUpdate = accountsService.save(account);
                            if(accountUpdate != null){

                                insertedStatement = save(statement);

                            }
                        }
                    }

                }else{
                    System.out.println(account);

                }

            }


        }




        return insertedStatement;
    }



    public Statement save(Statement statement) {
        final String methodName = "save() : ";
        System.out.println(methodName  + "called");

        Statement statement1= statementRepository.save(statement);



        return statement1;

    }

    public void deleteById(Long id) {

        statementRepository.deleteById(id);
    }
}
