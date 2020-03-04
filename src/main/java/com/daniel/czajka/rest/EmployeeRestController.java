package com.daniel.czajka.rest;

import com.daniel.czajka.dao.EmployeeDAO;
import com.daniel.czajka.entity.Employee;
import com.daniel.czajka.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    //inject employee dao
    @Autowired
    public EmployeeRestController(EmployeeService theemployeeService){
        employeeService = theemployeeService;
    }

    //expose "/employees and return list of employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }





}
