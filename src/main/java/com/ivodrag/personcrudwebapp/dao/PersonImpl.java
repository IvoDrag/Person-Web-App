package com.ivodrag.personcrudwebapp.dao;

import com.ivodrag.personcrudwebapp.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonImpl implements PersonDAO {

    private static final String INSERT_PERSON_QUERY = "INSERT INTO PERSON(id,name,gender,age) VALUES(?,?,?,?)";
    private static final String UPDATE_PERSON_BY_ID_QUERY = "UPDATE PERSON SET name=? WHERE id=?";
    private static final String DELETE_PERSON_BY_ID_QUERY = "DELETE FROM PERSON WHERE id=?";
    private static final String GET_PERSON_BY_ID_QUERY = "SELECT * FROM PERSON WHERE id=?";
    private static final String GET_ALL_PERSONS_QUERY = "SELECT * FROM PERSON";

    private JdbcTemplate jdbcTemplate;

    public PersonImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Person createPerson(Person person) {
        jdbcTemplate.update(INSERT_PERSON_QUERY, person.getId(), person.getName(), person.getGender(), person.getAge());
        return person;
    }

    @Override
    public Person updatePersonById(Person person) {
        jdbcTemplate.update(UPDATE_PERSON_BY_ID_QUERY, person.getName(), person.getId());
        return person;
    }

    @Override
    public String deletePersonById(int id) {
        jdbcTemplate.update(DELETE_PERSON_BY_ID_QUERY, id);
        return "Person with id " + id + " was deleted successfully!";
    }

    @Override
    public Person getPersonById(int id) {
        return jdbcTemplate.queryForObject(GET_PERSON_BY_ID_QUERY, (rs, rowNum) -> new Person(rs.getInt("id"), rs.getString("name"), rs.getString("gender"), rs.getInt("age")), id);
    }

    @Override
    public List<Person> getPersons() {
        return jdbcTemplate.query(GET_ALL_PERSONS_QUERY, (rs, rowNum) -> new Person(rs.getInt("id"), rs.getString("name"), rs.getString("gender"), rs.getInt("age")));
    }
}
