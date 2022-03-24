package com.example.campgemini.repository;

import com.example.campgemini.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

// @Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
