package com.abd3rr.applications_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import com.abd3rr.applications_service.model.ApplicationStatus;

@Getter
@Setter
public class JobApplicationRequest {
    @NotBlank
    private String companyName;

    private String location;

    @NotBlank
    private String positionTitle;

    private String jobUrl;

    private ApplicationStatus status; // APPLIED par défaut

    private String contactName;

    @Email
    private String contactEmail;

    @Size(max = 2000)
    private String notes;
}
