package com.example.jpaNew.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessorOrder;
import java.util.Date;

@Entity(name = "Investment")
@Table(name = "investment")
public class Investment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "rate")
    private Double rate;

    @Column(name = "duration")
    private Long duration;

    @Column(name = "accountNo")
    private String accountNo;

    @Column(name = "maturityAmount")
    private Double maturityAmount;

    @Column(name = "interestAmount")
    private Double interestAmount;

    public Investment() {
    }

    public Investment(Long id, String type, Long amount, Double rate, Long duration, String accountNo, Double maturityAmount, Double interestAmount) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.rate = rate;
        this.duration = duration;
        this.accountNo = accountNo;
        this.maturityAmount = maturityAmount;
        this.interestAmount = interestAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Double getMaturityAmount() {
        return maturityAmount;
    }

    public void setMaturityAmount(Double maturityAmount) {
        this.maturityAmount = maturityAmount;
    }

    public Double getInterestAmount() {
        return interestAmount;
    }

    public void setInterestAmount(Double interestAmount) {
        this.interestAmount = interestAmount;
    }
}
