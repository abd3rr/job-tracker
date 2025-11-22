package com.abd3rr.applications_service.dto;

import lombok.Getter;
import lombok.Setter;
import com.abd3rr.applications_service.model.ApplicationStatus;

import java.time.LocalDateTime;

@Getter
@Setter
public class JobApplicationResponse {
    private Long id;
    private String companyName;
    private String location;
    private String positionTitle;
    private String jobUrl;
    private ApplicationStatus status;
    private LocalDateTime appliedAt;
    private LocalDateTime lastUpdatedAt;
    private String contactName;
    private String contactEmail;
    private String notes;
}
