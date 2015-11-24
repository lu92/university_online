package com.universityonline.domain.entities;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Doctor extends Person {

    public Doctor() {
    }

    public Doctor(String name, String lastname, String username, String password, String birthday, String email) {
        super(name, lastname, username, password, birthday, email);
    }

    public Doctor(String name, String lastname, String username, String password, LocalDate birthday, String email) {
        super(name, lastname, username, password, birthday, email);
    }
}
