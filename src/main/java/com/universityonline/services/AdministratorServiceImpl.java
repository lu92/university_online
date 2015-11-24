package com.universityonline.services;

import com.universityonline.domain.entities.Student;
import com.universityonline.repositories.PersonRepository;
import com.universityonline.studentservice.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Service
//@Transactional
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private PersonRepository personRepository;

    private final Logger logger = Logger.getLogger("AdministratorServiceImpl");

    public CreateStudentResponse createStudent(CreateStudentRequest request) {
        CreateStudentResponse createStudentRS = new CreateStudentResponse();


        Student student = new Student(
                request.getName(),
                request.getLastname(),
                request.getUsername(),
                request.getPassword(),
                LocalDate.of(
                        request.getBirthday().getYear(),
                        request.getBirthday().getMonth(),
                        request.getBirthday().getDay()),
                request.getPassword());
        logger.debug(student);

        personRepository.saveOrUpdate(student);

        createStudentRS.setName(request.getName());
        createStudentRS.setLastname(request.getLastname());
        createStudentRS.setStatus("CONFIRMED");


//        createStudentRS.setStatus(CreationStatus.CONFIRMED);

        return createStudentRS;
    }

    public CreateDoctorResponse createDoctor(CreateDoctorRequest createDoctorRequest) {
        return null;
    }

    public CreateProfessorResponse createProfessor(CreateProfessorRequest createProfessorRequest) {
        return null;
    }

    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
}
