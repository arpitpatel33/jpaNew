package com.example.jpaNew.entities;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Transaction")
@Table(name = "transaction")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long amount;
    private String remarks;
    private Date date;

    public Transaction() {

    }

    public Transaction(Long id, Long amount, String remarks, Date date) {
        this.id = id;
        this.amount = amount;
        this.remarks = remarks;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }



}