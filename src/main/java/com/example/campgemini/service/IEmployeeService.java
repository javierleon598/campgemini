package com.example.campgemini.service;

import java.util.List;

import com.example.campgemini.entity.Employee;
// import com.example.campgemini.dto.Employees;
// import com.example.campgemini.dto.Response;

public interface IEmployeeService {

    void saveEmployee(Employee employee);

    List<Employee> getEmployees();
    
    Employee findByid(String id);

    void deleteEmployee(String id);

    // List<Response> getEmployeesByFilter(String position,String name);

}
