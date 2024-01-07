package com.srijan.myjpawork.twoWay.service;

import com.srijan.myjpawork.oneToOne.twoWay.model.Address;
import com.srijan.myjpawork.oneToOne.twoWay.model.Employee;
import com.srijan.myjpawork.oneToOne.twoWay.service.AddressService;
import com.srijan.myjpawork.oneToOne.twoWay.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class AddressServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private AddressService addressService;

    @Test
    public void employeeAndAddressCreateTest(){

        Employee employee = new Employee();
        employee.setEmail("srijan.veerareddy@gmail.com");
        employee.setFirstName("Srijan");
        employee.setLastName("Veerareddy");
        employee.setEmpNo("100");

        Address address = new Address();
        address.setEmployee(employee);
        address.setLine1("Austin");
        address.setCity("Austin");
        address.setZipCode("123345");
        address.setCity("US");
        address.setCountry("Texus");

        Address newAddress = addressService.createAddress(address);

        Employee newEmp = newAddress.getEmployee();

        List<Address> addressList = addressService.getAllAddress();

        assert newAddress != null;
        assert newEmp != null;
        assert addressList != null;

    }

    @Test
    public void employeeAndAddressUpdateTest(){
        //creating
        Employee employee = new Employee();
        employee.setEmail("srijan.veerareddy@gmail.com");
        employee.setFirstName("Srijan");
        employee.setLastName("Veerareddy");
        employee.setEmpNo("100");

        Address address = new Address();
        address.setEmployee(employee);
        address.setLine1("Austin");
        address.setCity("Austin");
        address.setZipCode("123345");
        address.setCity("US");
        address.setCountry("Texus");

        Address newAddress = addressService.createAddress(address);

        Employee newEmp = newAddress.getEmployee();

        List<Address> addressList = addressService.getAllAddress();

        assert newAddress != null;
        assert newEmp != null;
        assert addressList != null;

        //updating
        newEmp.setEmpNo("7887");
        Address updatedAddress = addressService.updateAddress(newAddress);

        Employee updatedEmp = updatedAddress.getEmployee();
        assertEquals(updatedEmp.getEmpNo(),"7887");

    }

}