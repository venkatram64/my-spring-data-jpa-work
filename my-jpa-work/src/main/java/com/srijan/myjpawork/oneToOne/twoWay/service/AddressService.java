package com.srijan.myjpawork.oneToOne.twoWay.service;

import com.srijan.myjpawork.exception.MyCommonApiException;
import com.srijan.myjpawork.oneToOne.twoWay.model.Address;
import com.srijan.myjpawork.oneToOne.twoWay.model.Employee;
import com.srijan.myjpawork.oneToOne.twoWay.repository.AddressRepository;
import com.srijan.myjpawork.oneToOne.twoWay.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public Address createAddress(Address address){
        Employee employee = address.getEmployee();
        if(employee == null){
            throw new MyCommonApiException("Employee object should not null");
        }
        Address newAddress = addressRepository.save(address);
        return newAddress;
    }

    public Address updateAddress(Address address){
        Employee employee = address.getEmployee();
        if(employee == null){
            throw new MyCommonApiException("Employee object should not null");
        }
        Address newAddress = addressRepository.save(address);
        return newAddress;
    }

    public List<Address> getAllAddress(){
        return addressRepository.findAll();
    }
}
