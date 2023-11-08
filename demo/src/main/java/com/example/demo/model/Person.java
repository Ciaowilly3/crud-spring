package com.example.demo.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name= "person")
public class Person {
    @Id
    private String id;

    private String name;

    // Costruttore senza parametri necessario per JPA
    public Person() {
        this.id = UUID.randomUUID().toString();
    }

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter e setter per name
    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return null;
    }

    // Getter per id
    public String getId() {
        return id;
    }


}
