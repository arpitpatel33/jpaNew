package com.example.jpaNew.entities;

import javax.persistence.*;

@Entity(name = "School")
@Table(name = "school")
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "dept_id")
    private Long id;

    @Column(name = "no_of_students")
    private Long students;

    @Column(name = "dept_name")
    private String dept_name;

    @Column(name = "hod")
    private String hod;

    public School() {
    }

    public School(Long id, Long students, String dept_name, String hod) {
        this.id = id;
        this.students = students;
        this.dept_name = dept_name;
        this.hod = hod;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudents() {
        return students;
    }

    public void setStudents(Long students) {
        this.students = students;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getHod() {
        return hod;
    }

    public void setHod(String hod) {
        this.hod = hod;
    }
}
