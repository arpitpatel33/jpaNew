package com.example.jpaNew.repositories;

import com.example.jpaNew.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee , Long> {

    public List< Employee> findAll();
}
