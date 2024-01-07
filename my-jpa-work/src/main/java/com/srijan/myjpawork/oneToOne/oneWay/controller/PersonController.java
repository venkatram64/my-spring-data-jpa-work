package com.srijan.myjpawork.oneToOne.oneWay.controller;

import com.srijan.myjpawork.oneToOne.oneWay.model.Person;
import com.srijan.myjpawork.oneToOne.oneWay.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    /*
    {
        "firstName": "Srijan",
        "lastName": "Veerareddy",
        "email": "srijan.veera@gmail.com",
        "personProfile":{
            "gender": "MALE",
            "birthDate": "2024/01/07",
            "phoneNumber": "123 123 1234"
        }
    }
     */

    @PostMapping
    public ResponseEntity<Person> createPersonAndPersonProfile(@RequestBody Person person){
        Person newPerson = personService.createPersonAndPersonProfile(person);
        return ResponseEntity.ok(newPerson);
    }

    /*
    {
        "id": 1,
        "firstName": "Srijan",
        "lastName": "Veerareddy",
        "email": "srijan.veerareddy@gmail.com",
        "personProfile":{
            "id":1,
            "gender": "MALE",
            "birthDate": "2024/01/07",
            "phoneNumber": "321 321 4321"
        }
    }
     */

    @PutMapping
    public ResponseEntity<Person> updatePersonAndPersonProfile(@RequestBody Person person){
        Person newPerson = personService.updatePersonAndPersonProfile(person);
        return ResponseEntity.ok(newPerson);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePersonAndPersonProfile(@PathVariable Integer id){
        personService.deletePersonById(id);
        return ResponseEntity.ok("Person is deleted");
    }

    @GetMapping
    public List<Person> getAllPersons(){
        return personService.getAllPersons();
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable Integer id){
        return personService.getPersonById(id);
    }
}
