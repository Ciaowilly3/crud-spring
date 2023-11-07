package com.example.demo.api;

import com.example.demo.model.Person;
import com.example.demo.service.impl.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    private final PersonServiceImpl personServiceImpl;
    @Autowired
    public PersonController(PersonServiceImpl personServiceImpl) {
        this.personServiceImpl = personServiceImpl;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person){
       personServiceImpl.addPerson(person);
    }

    @GetMapping
    public List<Person> getAllPeople(){
        return personServiceImpl.getAllPeople();
    }
    @GetMapping(path = "/{id}")
    public Person getPersonById(@PathVariable("id") UUID id){
        return personServiceImpl.getPersonById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id){
        personServiceImpl.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") UUID id,@RequestBody Person personToUpdate){
        personServiceImpl.updatePerson(id, personToUpdate);
    }
}

