package com.example.jpaNew.entities;

import javax.persistence.*;

@Table(name = "payroll")
@Entity(name = "PayRoll")
public class PayRoll {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String role;

    public PayRoll() {
    }

    public PayRoll(long id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
