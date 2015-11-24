package com.universityonline.domain.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

//    @Transient
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="COURSE_STUDENT",
            joinColumns={@JoinColumn(name="COURSE_ID")},
            inverseJoinColumns={@JoinColumn(name="STUDENT_ID")})
    private List<Student> students = new ArrayList<Student>();

    @Transient
    private List<Doctor> doctors;

    @ManyToOne
    @JoinColumn(name="professor_id")
    private Professor professor;

    public Course() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;

        Course course = (Course) o;

        if (!name.equals(course.name)) return false;
        return professor.equals(course.professor);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + professor.hashCode();
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
