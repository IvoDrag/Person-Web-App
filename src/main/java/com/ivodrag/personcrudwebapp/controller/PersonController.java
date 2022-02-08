package com.ivodrag.personcrudwebapp.controller;

import com.ivodrag.personcrudwebapp.dao.PersonDAO;
import com.ivodrag.personcrudwebapp.model.Person;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    private PersonDAO personDAO;

    public PersonController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @PostMapping("/user")
    public Person createPerson(@RequestBody Person person) {
        return personDAO.createPerson(person);
    }

    @PutMapping("/user/{id}")
    public Person updatePerson(@RequestBody Person person) {
        return personDAO.updatePersonById(person);
    }

    @GetMapping("/users")
    public List<Person> getPersons() {
        return personDAO.getPersons();
    }

    @DeleteMapping("/user/{id}")
    public String deletePerson(@PathVariable("id") int id) {
        return personDAO.deletePersonById(id);
    }

    @GetMapping("/user/{id}")
    public Person personById(@PathVariable("id") int id) {
        return personDAO.getPersonById(id);
    }

}
