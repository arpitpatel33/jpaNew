package com.example.jpaNew.repositories;


import com.example.jpaNew.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobRepository extends JpaRepository<Job, Long> {

    List<Job> findAll();
}
