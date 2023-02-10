package com.example.jpaNew.services;


import com.example.jpaNew.entities.PayRoll;
import com.example.jpaNew.repositories.PayRollRepository;
import com.example.jpaNew.services.PayRollServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PayRollService implements PayRollServiceInterface {


    @Autowired
    private PayRollRepository payRollRepository;
    @Override
    public PayRoll createPayRoll(PayRoll payRoll) {
        return payRollRepository.save(payRoll);
    }
}