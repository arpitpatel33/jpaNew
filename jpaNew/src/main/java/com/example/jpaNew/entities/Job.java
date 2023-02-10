package com.example.jpaNew.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "job")
@Entity(name = "Job")
public class Job {

    @Id
    @Column(name = "job_id")
    private Long jobId;

    public Job(Long jobId, String jobDesignation, String jobDepartment) {
        this.jobId = jobId;
        this.jobDesignation = jobDesignation;
        this.jobDepartment = jobDepartment;
    }

    @Column(name = "designation")
    private String jobDesignation;

    @Column(name = "department")
    private String jobDepartment;

    public Job() {
    }



    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getJobDesignation() {
        return jobDesignation;
    }

    public void setJobDesignation(String jobDesignation) {
        this.jobDesignation = jobDesignation;
    }

    public String getJobDepartment() {
        return jobDepartment;
    }

    public void setJobDepartment(String jobDepartment) {
        this.jobDepartment = jobDepartment;
    }

    public Object all() {
        return all();
    }
}
