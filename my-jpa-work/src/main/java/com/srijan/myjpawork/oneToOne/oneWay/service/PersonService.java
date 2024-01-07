package com.srijan.myjpawork.oneToOne.oneWay.service;

import com.srijan.myjpawork.exception.MyCommonApiException;
import com.srijan.myjpawork.oneToOne.oneWay.model.Person;
import com.srijan.myjpawork.oneToOne.oneWay.model.PersonProfile;
import com.srijan.myjpawork.oneToOne.oneWay.repository.PersonProfileRepository;
import com.srijan.myjpawork.oneToOne.oneWay.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonProfileRepository personProfileRepository;

    public Person createPersonAndPersonProfile(Person person){
        PersonProfile pp = person.getPersonProfile();
        if(pp == null){
            throw new MyCommonApiException("PersonProfile object should be null");
        }
        Person newPerson = personRepository.save(person);
        return newPerson;
    }

    public Person updatePersonAndPersonProfile(Person person){
        PersonProfile pp = person.getPersonProfile();
        if(pp == null){
            throw new MyCommonApiException("PersonProfile object should be null");
        }
        PersonProfile newPP = personProfileRepository.save(pp);
        person.setPersonProfile(newPP);
        Person newPerson = personRepository.save(person);
        return newPerson;
    }

    public boolean deletePersonById(Integer id){
        personRepository.deleteById(id);
        return true;
    }

    public Person getPersonById(Integer id){
        return personRepository.findById(id).get();
    }

    public List<Person> getAllPersons(){
        return personRepository.findAll();
    }
}
