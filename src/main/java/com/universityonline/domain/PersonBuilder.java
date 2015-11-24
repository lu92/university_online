package com.universityonline.domain;

import com.universityonline.domain.entities.Doctor;
import com.universityonline.domain.entities.Person;
import com.universityonline.domain.entities.Professor;
import com.universityonline.domain.entities.Student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PersonBuilder {
    private Person person;

    public PersonBuilder() {
    }

    public PersonBuilder(Person person) {
        this.person = person;
    }

    public PersonBuilder(PersonType type, String name, String lastname, String username, String password, String birthday, String email) {
        switch (type) {
            case STUDENT:
                person = new Student(name, lastname, username, password, LocalDate.parse(birthday, DateTimeFormatter.ISO_DATE), email);
                break;

            case DOCTOR:
                person = new Doctor(name, lastname, username, password, LocalDate.parse(birthday, DateTimeFormatter.ISO_DATE), email);
                break;

            case PROFESSOR:
                person = new Professor(name, lastname, username, password, LocalDate.parse(birthday, DateTimeFormatter.ISO_DATE), email);
                break;
        }
    }

    public Long getId() {
        return person.getId();
    }

    public final PersonBuilder withId(Long id) {
        person.setId(id);
        return this;
    }

    public String getName() {
        return person.getName();
    }

    public final PersonBuilder withName(String name) {
        person.setName(name);
        return this;
    }

    public String getLastname() {
        return person.getLastname();
    }

    public final PersonBuilder withLastname(String lastname) {
        person.setLastname(lastname);
        return this;
    }

    public String getUsername() {
        return person.getUsername();
    }

    public final PersonBuilder withUsername(String username) {
        person.setUsername(username);
        return this;
    }

    public String getPassword() {
        return person.getPassword();
    }

    public final PersonBuilder withPassword(String password) {
        person.setPassword(password);
        return this;
    }

    public LocalDate getBirthday() {
        return person.getBirthday();
    }

    public final PersonBuilder withBirthday(LocalDate birthday) {
        person.setBirthday(birthday);
        return this;
    }

    public String getEmail() {
        return person.getEmail();
    }

    public final PersonBuilder withEmail(String email) {
        person.setEmail(email);
        return this;
    }

    public final Person getPerson() {
        return person;
    }
}
