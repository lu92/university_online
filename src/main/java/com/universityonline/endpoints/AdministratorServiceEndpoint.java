package com.universityonline.endpoints;

import com.universityonline.services.AdministratorService;
import com.universityonline.studentservice.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class AdministratorServiceEndpoint {

    private final Logger logger = Logger.getLogger("StudentServiceEndpoint");
    private static final String TARGET_NAMESPACE = "http://studentservice.universityonline.com";

    @Autowired
    private AdministratorService administratorService;

    @PayloadRoot(localPart = "CreateStudentRequest", namespace = TARGET_NAMESPACE)
    public @ResponsePayload
    CreateStudentResponse createStudent(@RequestPayload CreateStudentRequest createStudentRequest) {
        logger.info("createStudent CALLED");
        return administratorService.createStudent(createStudentRequest);
    }

    @PayloadRoot(localPart = "CreateDoctorRequest", namespace = TARGET_NAMESPACE)
    public @ResponsePayload
    CreateDoctorResponse createDoctor(@RequestPayload CreateDoctorRequest createDoctorRequest) {
        logger.info("createDoctor CALLED");
        return administratorService.createDoctor(createDoctorRequest);
    }

    @PayloadRoot(localPart = "CreateProfessorRequest", namespace = TARGET_NAMESPACE)
    public @ResponsePayload
    CreateProfessorResponse createProfessor(@RequestPayload CreateProfessorRequest createProfessorRequest) {
        logger.info("createProfessor CALLED");
        return administratorService.createProfessor(createProfessorRequest);
    }

    public void setAdministratorService(AdministratorService administratorService) {
        this.administratorService = administratorService;
    }
}
