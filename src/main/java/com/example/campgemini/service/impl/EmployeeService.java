package com.example.campgemini.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

// import com.example.campgemini.entity.Candidate;
import com.example.campgemini.entity.Employee;
// import com.example.campgemini.dto.Employees;
// import com.example.campgemini.dto.Response;
// import com.example.campgemini.repository.CandidateRepository;
import com.example.campgemini.repository.EmployeeRepository;
// import com.example.campgemini.repository.PositionRepository;
import com.example.campgemini.service.IEmployeeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    private static Logger LOG = LoggerFactory.getLogger(EmployeeService.class);

    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void saveEmployee(Employee employee){
        LOG.info("@saveEmployee",employee.toString());
        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployees(){

        LOG.info("@getEmployees");
        
        List<Employee> employeeList = employeeRepository.findAll();

        // List<Employee> employeeList = new ArrayList<Employee>();
        // for (Employee employee : employeeList) {
        //     Employee employee = new Employee();
        //     employee.setId(employee.getId());
        //     employee.setSalary(employee.getSalary());
        //     // employee.setName(employee.getPosition().getName());
        //     employeeList.add(employee);
        // }
    
        return employeeList;
    }

    @Override
    public Employee findByid(String id){

        LOG.info("@findByid");
        Optional<Employee> resultEmployee = employeeRepository.findById(Long.parseLong(id));  //return Optional
        Employee employee = resultEmployee.get();  //return User

        return employee;
    }

    @Override
    public void deleteEmployee(String id){
        employeeRepository.deleteById(Long.parseLong(id));
    }

}
