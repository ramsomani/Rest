package com.socgen.ndod.service;

import com.socgen.ndod.dao.EmployeeDb;
import com.socgen.ndod.modal.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeDb employeeDb;

    public List<Employee> getEmployeeDetails(){
        return (List<Employee>) employeeDb.findAll();
    }

    public Employee getEmployeeBySal(Double sal){
        return employeeDb.findBySal(sal);
    }

}
