package com.universityonline.services;

import com.universityonline.studentservice.*;

public interface AdministratorService {
    CreateStudentResponse createStudent(CreateStudentRequest createStudentRequest);
    CreateDoctorResponse createDoctor(CreateDoctorRequest createDoctorRequest);
    CreateProfessorResponse createProfessor(CreateProfessorRequest createProfessorRequest);
}
