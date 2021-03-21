package com.socgen.ndod.dao;

import com.socgen.ndod.modal.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDb extends CrudRepository<Employee,Integer> {

    Employee findByEmpName(String empName);

    @Query("select emp from Employee emp where emp.empSal>10000")
    Employee findBySal(Double sal);

}
