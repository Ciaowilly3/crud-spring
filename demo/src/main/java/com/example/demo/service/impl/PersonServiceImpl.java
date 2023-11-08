package com.example.demo.service.impl;

import com.example.demo.dao.PersonRepository;
import com.example.demo.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonServiceImpl {


    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository){
        this.personRepository = personRepository;
    }
    public Person addPerson(Person person){

        return personRepository.save(person);
    }
    public List<Person> getAllPeople(){
        return  personRepository.findAll();
    }

    public Optional<Person> getPersonById(String id){
        return personRepository.findById(id);
    }

    public void deletePerson(String id){
        personRepository.deleteById(id);
    }

    public Person updatePerson(String idToUpdate, Person person){
        Optional<Person> personToUpdate = personRepository.findById(idToUpdate);
            return personToUpdate
                    .map(p -> {
                        p.setName(person.getName());
                        personRepository.save(p);
                        return p;
                    })
                                .orElse(null);
                    }

    }

 /*   public int updatePerson(UUID id, Person newPerson){
        return personRepository.save(id, newPerson);
    }*/

