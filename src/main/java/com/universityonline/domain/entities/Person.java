package com.universityonline.domain.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
public abstract class Person {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;
    private String username;
    private String password;
    private LocalDate birthday;
    private String email;

    public Person() {
    }

    public Person(String name, String lastname, String username, String password, String birthday, String email) {
        this(name, lastname, username, password, LocalDate.parse(birthday, DateTimeFormatter.ISO_DATE), email);
    }

    public Person(String name, String lastname, String username, String password, LocalDate birthday, String email) {
        this.name = name;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.birthday = birthday;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (!name.equals(person.name)) return false;
        if (!lastname.equals(person.lastname)) return false;
        if (!username.equals(person.username)) return false;
        return email.equals(person.email);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + lastname.hashCode();
        result = 31 * result + username.hashCode();
        result = 31 * result + email.hashCode();
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                '}';
    }
}
