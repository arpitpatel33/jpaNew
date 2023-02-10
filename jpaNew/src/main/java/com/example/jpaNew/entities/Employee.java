package com.example.jpaNew.entities;

import javax.persistence.*;

@Table(name = "employee")
@Entity(name = "Employee")
public class Employee {

    @Id
    @Column(name = "emp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long eId;

    @Column(name = "emp_name")
    private String eName;

    @Column(name = "emp_salary")
    private long eSalary;

    public long geteId() {
        return eId;
    }

    public void seteId(long eId) {
        this.eId = eId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public long geteSalary() {
        return eSalary;
    }

    public void seteSalary(long eSalary) {
        this.eSalary = eSalary;
    }
}