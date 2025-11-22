package com.abd3rr.applications_service.repository;

import com.abd3rr.applications_service.model.ApplicationStatus;
import com.abd3rr.applications_service.model.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {
    List<JobApplication> findByStatus(ApplicationStatus status);

    List<JobApplication> findByCompanyNameIgnoreCaseContaining(String companyName);

}
