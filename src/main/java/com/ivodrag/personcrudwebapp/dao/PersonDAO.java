package com.ivodrag.personcrudwebapp.dao;

import com.ivodrag.personcrudwebapp.model.Person;

import java.util.List;

public interface PersonDAO {
    Person createPerson(Person person);

    Person updatePersonById(Person person);

    String deletePersonById(int id);

    Person getPersonById(int id);

    List<Person> getPersons();
}
