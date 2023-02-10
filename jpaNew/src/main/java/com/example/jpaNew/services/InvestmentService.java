package com.example.jpaNew.services;

import com.example.jpaNew.entities.Accounts;
import com.example.jpaNew.entities.Investment;
import com.example.jpaNew.repositories.AccountsRepository;
import com.example.jpaNew.repositories.InvestmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class InvestmentService {

    private static final Logger log = LoggerFactory.getLogger(InvestmentService.class);

    @Autowired
    private InvestmentRepository investmentRepository;

    @Autowired
    private AccountsService accountsService;

    @Autowired
    private AccountsRepository accountsRepository;

    public List<Investment> findAll() {
        final String methodName = "findAll() : ";
        log.info(methodName + "called");

        List<Investment> all= investmentRepository.findAll();
        return all;
    }

    public Optional<Investment> findById(Long id) {
        final String methodName = "findById() : ";
        log.info(methodName + "called " + id);

        Optional <Investment> byId= investmentRepository.findById(id);
        return byId;
    }

    public List<Investment> getByIdGreaterThanEqualAndIdLessThanEqual(Long startId, Long endId) {

        List<Investment> byId= investmentRepository.findByIdGreaterThanEqualAndIdLessThanEqual(startId,endId);
        return byId;
    }

    public Investment save(Investment investment) {

        Investment byId= investmentRepository.save(investment);
        return byId;
    }

    public void deleteById(Long id) {

        investmentRepository.deleteById(id);

    }

    public Investment getById(Long id) {

        Investment byId= investmentRepository.findById(id).get();
        return byId;
    }

    @Transactional
    public Investment processInvestment(Investment investment){
        final String methodName = "processInvestment() : ";
        log.info(methodName + "called " + investment);

        if(investment != null )
        {
            String accountNo= investment.getAccountNo();
            log.info(methodName + " Account no is  " + accountNo);
            if(accountNo!=null)
            {
                Accounts accounts= accountsService.getByAccountNo(accountNo);
                log.info(methodName + " Accounts is  " + accounts);
                if(accounts!=null)
                {
                    log.info(methodName + " Accounts is  " + accounts);
                    String investmentType= investment.getType();
                    log.info(methodName + " investment type is  " + investmentType);

                    if(investmentType!=null)
                    {
                        if(investmentType.equals("FD"))
                        {
                            double balance= accounts.getBalance();
                            double fdAmount= investment.getAmount();

                            if(balance> fdAmount)
                            {
                                double newBalance= balance-fdAmount;
                                accounts.setBalance(newBalance);
                            }

                            Accounts accountUpdate= accountsService.save(accounts);
                            double rateFD = investment.getRate();
                            Long durationFD= investment.getDuration();
                            double interestFD= (fdAmount*rateFD*durationFD)/100;
                            investment.setInterestAmount(interestFD);
                            double maturityFd= fdAmount+interestFD;
                            investment.setMaturityAmount(maturityFd);

                        }
                        else if(investmentType.equals("TaxSavingPPf"))
                        {
                            double balance= accounts.getBalance();
                            double taxSavingPpf= investment.getAmount();

                            if (balance>taxSavingPpf)
                            {
                                double newBalance= balance- taxSavingPpf;
                                accounts.setBalance(newBalance);

                            }
                            Accounts accountUpdate= accountsService.save(accounts);
                            double taxSavingRate= investment.getRate();
                            Long taxSavingDuration= investment.getDuration();
                            double taxSavingInterest= (taxSavingPpf*taxSavingRate*taxSavingDuration)/100;
                            investment.setInterestAmount(taxSavingInterest);
                            double maturityTaxSaving= taxSavingPpf+taxSavingInterest;
                            investment.setMaturityAmount(maturityTaxSaving);
                        }
                        else if (investmentType.equals("PPF"))
                        {
                            double balance= accounts.getBalance();
                            double ppf= investment.getAmount();
                            if(balance>ppf)
                            {
                                double newBalance= balance-ppf;
                                accounts.setBalance(newBalance);
                            }
                            Accounts accountUpdate= accountsService.save(accounts);

                            double ppfRate= investment.getRate();
                            Long ppfDuration= investment.getDuration();

                            double ppfInterest = calculateSimpleInterest(ppf,ppfRate,ppfDuration);
                            investment.setInterestAmount(ppfInterest);

                            double maturityPpf= ppf+ppfInterest;
                            investment.setMaturityAmount(maturityPpf);
                        }
                        //update account
                        //insert investment
                    }
                }
            }

        }
        return investment;
    }

    private double calculateSimpleInterest(double principal,double rate, double duration){
        final String methodName = "calculateSimpleInterest() : ";
        log.info(methodName + "called " + principal + rate + duration);

        double simpleInterest = (principal * rate * duration)/100;
        log.info(methodName + "calculated simple interest is " + simpleInterest);
        return simpleInterest;
    }




}
