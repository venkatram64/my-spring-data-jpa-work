package com.srijan.myjpawork.oneToOne.service;

import com.srijan.myjpawork.oneToOne.model.Address;
import com.srijan.myjpawork.oneToOne.model.Employee;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
//@ActiveProfiles("dev")
class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void employeeCreateTest(){

        Address address = new Address();
        address.setLine1("Austin");
        address.setCity("Austin");
        address.setZipCode("123345");
        address.setCity("US");
        address.setCountry("Texus");

        Employee employee = new Employee();
        employee.setAddress(address);
        employee.setEmail("srijan.veerareddy@gmail.com");
        employee.setFirstName("Srijan");
        employee.setLastName("Veerareddy");
        employee.setEmpNo("100");

        Employee emp = employeeService.createEmployee(employee);

        assert emp != null;

    }

}