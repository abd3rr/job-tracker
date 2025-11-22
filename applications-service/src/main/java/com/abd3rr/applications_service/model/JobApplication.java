package com.abd3rr.applications_service.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "job_applications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String companyName;

    private String location;

    @Column(nullable = false)
    private String positionTitle;
    private String jobUrl;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private ApplicationStatus status = ApplicationStatus.APPLIED;

    private LocalDateTime appliedAt;
    private LocalDateTime lastUpdatedAt;

    private String contactName;
    private String contactEmail;

    @Column(length = 2000)
    private String notes;
}
