package com.daniel.czajka.dao;


import com.daniel.czajka.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    //get all employees
    public List<Employee> findALl();

    public Employee findById(int theId);

    public void save(Employee theEmployee);

    public void deleteById(int theId);




}
