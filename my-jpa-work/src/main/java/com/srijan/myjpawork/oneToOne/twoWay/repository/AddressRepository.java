package com.srijan.myjpawork.oneToOne.twoWay.repository;

import com.srijan.myjpawork.oneToOne.twoWay.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
