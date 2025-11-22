package com.abd3rr.applications_service.service;


import com.abd3rr.applications_service.dto.JobApplicationRequest;
import com.abd3rr.applications_service.dto.JobApplicationResponse;
import com.abd3rr.applications_service.mapper.JobApplicationMapper;
import com.abd3rr.applications_service.model.ApplicationStatus;
import com.abd3rr.applications_service.model.JobApplication;
import org.springframework.stereotype.Service;
import com.abd3rr.applications_service.repository.JobApplicationRepository;

import java.util.List;

@Service
public class JobApplicationService {
    private final JobApplicationRepository jobApplicationRepository;

    public JobApplicationService(JobApplicationRepository jobApplicationRepository) {
        this.jobApplicationRepository = jobApplicationRepository;
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
