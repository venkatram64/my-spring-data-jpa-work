package com.srijan.myjpawork.oneToOne.repository;

import com.srijan.myjpawork.oneToOne.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
}
