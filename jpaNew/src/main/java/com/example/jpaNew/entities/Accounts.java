package com.example.jpaNew.entities;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Accounts")
@Table(name = "accounts")
public class Accounts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    public String type;

    @Column(name = "balance")
    private double balance;



    @Column(name = "account_no")
    private String accountNo;

    @Column(name = "last_updated_on")
    private Date last_updated_on;

    @Column(name = "last_updated_by")
    private String last_updated_by;



    public Accounts() {
    }

    public Accounts(Long id, String name, String type, double balance, Date last_updated_on, String last_updated_by) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.balance = balance;
        this.last_updated_on = last_updated_on;
        this.last_updated_by = last_updated_by;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getLast_updated_on() {
        return last_updated_on;
    }

    public void setLast_updated_on(Date last_updated_on) {
        this.last_updated_on = last_updated_on;
    }

    public String getLast_updated_by() {
        return last_updated_by;
    }

    public void setLast_updated_by(String last_updated_by) {
        this.last_updated_by = last_updated_by;
    }
}
