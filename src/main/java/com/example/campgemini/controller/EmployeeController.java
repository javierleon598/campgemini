package com.example.campgemini.controller;

import java.util.List;

import com.example.campgemini.entity.Employee;
// import com.example.campgemini.dto.Employees;
// import com.example.campgemini.dto.Response;
import com.example.campgemini.service.IEmployeeService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/v1")
public class EmployeeController {

    @Autowired
    IEmployeeService employeeService;

    private static Logger LOG = LoggerFactory.getLogger(EmployeeController.class);

    @GetMapping("/employee")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }

    @GetMapping("/employee/{id}")
    @CrossOrigin(origins = "*")
    public Employee getEmployees(@PathVariable String id){
        return employeeService.findByid(id);
    }

    @PostMapping("/employee")
    public Employee saveEmployees(@RequestBody Employee employee){
        LOG.info("employee", employee.toString());
        employeeService.saveEmployee(employee);
        return employee;
    }
    	
	@PutMapping("/employee")
	public Employee modifyEmployee(@RequestBody Employee employee) {
		employeeService.saveEmployee(employee);
		return employee;
	} 
	
	@DeleteMapping("/employee")
	public String deleteEmployee(@RequestParam("id") String id) {
		employeeService.deleteEmployee(id);
		return "Employee Deleted";
	}

}
