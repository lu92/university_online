package com.universityonline.domain.entities;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Professor extends Person {

    @OneToMany(mappedBy="professor")
    private List<Course> courses = new ArrayList<Course>();

    public Professor() {
    }

    public Professor(String name, String lastname, String username, String password, String birthday, String email) {
        super(name, lastname, username, password, birthday, email);
    }

    public Professor(String name, String lastname, String username, String password, LocalDate birthday, String email) {
        super(name, lastname, username, password, birthday, email);
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
