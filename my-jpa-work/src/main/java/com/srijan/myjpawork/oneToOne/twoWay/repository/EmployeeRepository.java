package com.srijan.myjpawork.oneToOne.twoWay.repository;

import com.srijan.myjpawork.oneToOne.twoWay.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    public Employee findByEmail(String email);
}
