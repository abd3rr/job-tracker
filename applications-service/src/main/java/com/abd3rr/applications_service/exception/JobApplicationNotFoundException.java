package com.abd3rr.applications_service.exception;

public class JobApplicationNotFoundException extends RuntimeException {

    public JobApplicationNotFoundException(Long id) {
        super("Job application with id " + id + " not found");
    }
}
