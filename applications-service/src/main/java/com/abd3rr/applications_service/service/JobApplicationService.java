package com.abd3rr.applications_service.service;


import com.abd3rr.applications_service.dto.JobApplicationRequest;
import com.abd3rr.applications_service.dto.JobApplicationResponse;
import com.abd3rr.applications_service.exception.JobApplicationNotFoundException;
import com.abd3rr.applications_service.mapper.JobApplicationMapper;
import com.abd3rr.applications_service.model.ApplicationStatus;
import com.abd3rr.applications_service.model.JobApplication;
import org.springframework.stereotype.Service;
import com.abd3rr.applications_service.repository.JobApplicationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JobApplicationService {
    private final JobApplicationRepository jobApplicationRepository;

    public JobApplicationService(JobApplicationRepository jobApplicationRepository) {
        this.jobApplicationRepository = jobApplicationRepository;
    }

    public JobApplicationResponse findById(Long id) {
        Optional<JobApplication> jobApplication = jobApplicationRepository.findById(id);
        return jobApplication.map(JobApplicationMapper::toResponse).orElseThrow(()-> new JobApplicationNotFoundException(id));
    }

    public List<JobApplicationResponse> findAll() {
        return jobApplicationRepository.findAll().stream()
                .map(JobApplicationMapper::toResponse)
                .toList();
    }

    public List<JobApplicationResponse> findByStatus(ApplicationStatus status) {
        return jobApplicationRepository.findByStatus(status).stream()
                .map(JobApplicationMapper::toResponse)
                .toList();
    }

    public JobApplicationResponse create(JobApplicationRequest request) {
        JobApplication entity = JobApplicationMapper.toEntity(request);
        JobApplication saved = jobApplicationRepository.save(entity);
        return JobApplicationMapper.toResponse(saved);
    }


}
