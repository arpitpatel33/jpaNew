package com.example.jpaNew.entities;

import javax.persistence.*;

@Entity(name = "College")
@Table(name = "college")
public class College {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "col_id")
    private Long id;

    @Column(name = "col_name")
    private String college_name;

    @Column(name = "department")
    private String department;

    public College(Long id, String college_name, String department, Long students) {
        this.id = id;
        this.college_name = college_name;
        this.department = department;
        this.students = students;
    }

    @Column(name= "students")
    private Long students;


    public College() {
    }

    public College(Long id, String college_name, String department) {
        this.id = id;
        this.college_name = college_name;
        this.department = department;
    }

    public Long getStudents() {
        return students;
    }

    public void setStudents(Long students) {
        this.students = students;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCollege_name() {
        return college_name;
    }

    public void setCollege_name(String college_name) {
        this.college_name = college_name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

}
