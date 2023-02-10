package com.example.jpaNew.repositories;

import com.example.jpaNew.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List< Student> findAll();
}
