package com.example.demo.dao;

import com.example.demo.model.Person;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface PersonRepository extends JpaRepository<Person, UUID> {


    Person save(Person person);
    List<Person> findAll();

    Optional<Person> findById(UUID id);

    void deleteById(UUID id);
}
    /*int insertPerson(Person person);


    List<Person> selectAllPeople();

    Optional<Person> selectPersonById(UUID id);
    int deletePersonById(UUID id);

    int updatePersonById(UUID id, Person person);
}*/
