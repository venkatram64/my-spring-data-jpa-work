package com.srijan.myjpawork.oneToOne.oneWay.repository;

import com.srijan.myjpawork.oneToOne.oneWay.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
