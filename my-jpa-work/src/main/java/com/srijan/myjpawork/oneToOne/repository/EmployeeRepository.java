package com.srijan.myjpawork.oneToOne.repository;

import com.srijan.myjpawork.oneToOne.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    public Employee findByEmail(String email);
}
