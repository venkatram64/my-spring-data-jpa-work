package com.srijan.myjpawork.oneToOne.oneWay.repository;

import com.srijan.myjpawork.oneToOne.oneWay.model.PersonProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonProfileRepository  extends JpaRepository<PersonProfile, Integer> {
}
