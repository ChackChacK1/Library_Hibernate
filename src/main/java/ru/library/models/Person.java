package ru.library.models;


import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private int person_id;

    @Column(name = "name")
    private String name;

    @Column(name = "birthdate")
    private int birthDate;

    @OneToMany
    private List<Book> books;

    public Person(int person_id, int birthDate, String name) {
        this.person_id = person_id;
        this.birthDate = birthDate;
        this.name = name;
    }

    public Person() {}

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(int birthDate) {
        this.birthDate = birthDate;
    }
}
