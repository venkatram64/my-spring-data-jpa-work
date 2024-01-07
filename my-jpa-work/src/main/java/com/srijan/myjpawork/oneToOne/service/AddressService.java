package com.srijan.myjpawork.oneToOne.service;

import com.srijan.myjpawork.oneToOne.model.Address;
import com.srijan.myjpawork.oneToOne.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public List<Address> getAllAddress(){
        return addressRepository.findAll();
    }
}
