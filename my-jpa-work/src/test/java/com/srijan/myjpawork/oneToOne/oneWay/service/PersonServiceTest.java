package com.srijan.myjpawork.oneToOne.oneWay.service;

import com.srijan.myjpawork.oneToOne.oneWay.model.Gender;
import com.srijan.myjpawork.oneToOne.oneWay.model.Person;
import com.srijan.myjpawork.oneToOne.oneWay.model.PersonProfile;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class PersonServiceTest {

    @Autowired
    private PersonService personService;

    @Test
    public void createPersonAndPersonProfile() {
        PersonProfile pp = new PersonProfile();
        pp.setGender(Gender.MALE);
        pp.setBirthDate(LocalDate.of(2000, 8,24));
        pp.setPhoneNumber("123 123 1234");

        Person p = new Person();
        p.setFirstName("Srijan");
        p.setLastName("Veerareddy");
        p.setEmail("srijan.veerareddy@gmail.com");
        p.setPersonProfile(pp);
        Person newPerson = personService.createPersonAndPersonProfile(p);

        PersonProfile newPP = newPerson.getPersonProfile();

        assert newPerson != null;
        assert newPP != null;
    }

    @Test
    public void updatePersonAndPersonProfile() {

        //creation
        PersonProfile pp = new PersonProfile();
        pp.setGender(Gender.MALE);
        pp.setBirthDate(LocalDate.of(2000, 8,24));
        pp.setPhoneNumber("123 123 1234");

        Person p = new Person();
        p.setFirstName("Srijan");
        p.setLastName("Veerareddy");
        p.setEmail("srijan.veerareddy@gmail.com");
        p.setPersonProfile(pp);
        Person newPerson = personService.createPersonAndPersonProfile(p);

        PersonProfile newPP = newPerson.getPersonProfile();

        //updation
        newPerson.setEmail("Srijan.Veerareddy@hotmail.com");
        newPP.setPhoneNumber("321 321 4321");
        newPerson.setPersonProfile(newPP);

        Person updatedPerson = personService.createPersonAndPersonProfile(newPerson);

        PersonProfile updatedPP = updatedPerson.getPersonProfile();

        assert updatedPerson != null;
        assert updatedPP != null;
    }

}