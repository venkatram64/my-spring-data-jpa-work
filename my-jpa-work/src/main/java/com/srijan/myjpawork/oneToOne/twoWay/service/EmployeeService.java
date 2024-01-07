package com.srijan.myjpawork.oneToOne.twoWay.service;

import com.srijan.myjpawork.exception.MyCommonApiException;
import com.srijan.myjpawork.oneToOne.twoWay.model.Employee;
import com.srijan.myjpawork.oneToOne.twoWay.repository.AddressRepository;
import com.srijan.myjpawork.oneToOne.twoWay.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Transactional
    public Employee createEmployee(Employee employee){
        //validating employee object
        if(employee.getAddress() == null ){
            throw new MyCommonApiException("Employee should not have address");
        }

        if(employee.getEmail() == null || employee.getEmail().isEmpty()){
            throw new MyCommonApiException("Employee email should not be empty");
        }

        if(employee.getFirstName() == null || employee.getFirstName().isEmpty()){
            throw new MyCommonApiException("Employee first name should not be empty");
        }

        if(employee.getLastName() == null || employee.getLastName().isEmpty()){
            throw new MyCommonApiException("Employee last name should not be empty");
        }

        if(employee.getAddress() != null){
            addressRepository.save(employee.getAddress());
        }
        return employeeRepository.save(employee);
    }

    @Transactional
    public Employee updateEmployee(Employee employee){
        //validating employee object
        if(employee.getAddress() == null ){
            throw new MyCommonApiException("Employee should not have address");
        }

        if(employee.getEmail() == null || employee.getEmail().isEmpty()){
            throw new MyCommonApiException("Employee email should not be empty");
        }

        if(employee.getFirstName() == null || employee.getFirstName().isEmpty()){
            throw new MyCommonApiException("Employee first name should not be empty");
        }

        if(employee.getLastName() == null || employee.getLastName().isEmpty()){
            throw new MyCommonApiException("Employee last name should not be empty");
        }

        if(employee.getAddress() != null){
            addressRepository.save(employee.getAddress());
        }
        return employeeRepository.save(employee);
    }

    @Transactional
    public boolean deleteEmployeeById(Integer employeeId){
        employeeRepository.deleteById(employeeId);
        return true;
    }


    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeByEmail(String email){
        return employeeRepository.findByEmail(email);
    }

    public Employee getEmployeeById(Integer id){
        return employeeRepository.findById(id).get();
    }
}
