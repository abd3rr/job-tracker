package com.abd3rr.applications_service.mapper;

import com.abd3rr.applications_service.dto.JobApplicationRequest;
import com.abd3rr.applications_service.dto.JobApplicationResponse;
import com.abd3rr.applications_service.model.ApplicationStatus;
import com.abd3rr.applications_service.model.JobApplication;

import java.time.LocalDateTime;

public class JobApplicationMapper {
    public static JobApplication toEntity(JobApplicationRequest request) {
        LocalDateTime now = LocalDateTime.now();

        return JobApplication.builder()
                .companyName(request.getCompanyName())
                .location(request.getLocation())
                .positionTitle(request.getPositionTitle())
                .jobUrl(request.getJobUrl())
                .status(request.getStatus() != null ? request.getStatus() : ApplicationStatus.APPLIED)
                .appliedAt(now)
                .lastUpdatedAt(now)
                .contactName(request.getContactName())
                .contactEmail(request.getContactEmail())
                .notes(request.getNotes())
                .build();
    }

    public static void updateEntity(JobApplication entity, JobApplicationRequest request) {
        entity.setCompanyName(request.getCompanyName());
        entity.setLocation(request.getLocation());
        entity.setPositionTitle(request.getPositionTitle());
        entity.setJobUrl(request.getJobUrl());
        entity.setStatus(request.getStatus() != null ? request.getStatus() : entity.getStatus());
        entity.setContactName(request.getContactName());
        entity.setContactEmail(request.getContactEmail());
        entity.setNotes(request.getNotes());
        entity.setLastUpdatedAt(LocalDateTime.now());
    }

    public static JobApplicationResponse toResponse(JobApplication entity) {
        JobApplicationResponse response = new JobApplicationResponse();
        response.setId(entity.getId());
        response.setCompanyName(entity.getCompanyName());
        response.setLocation(entity.getLocation());
        response.setPositionTitle(entity.getPositionTitle());
        response.setJobUrl(entity.getJobUrl());
        response.setStatus(entity.getStatus());
        response.setAppliedAt(entity.getAppliedAt());
        response.setLastUpdatedAt(entity.getLastUpdatedAt());
        response.setContactName(entity.getContactName());
        response.setContactEmail(entity.getContactEmail());
        response.setNotes(entity.getNotes());
        return response;
    }
}
