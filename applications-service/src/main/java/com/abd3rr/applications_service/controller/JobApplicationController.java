package com.abd3rr.applications_service.controller;

import com.abd3rr.applications_service.dto.JobApplicationRequest;
import com.abd3rr.applications_service.dto.JobApplicationResponse;
import jakarta.validation.Valid;
import com.abd3rr.applications_service.model.ApplicationStatus;
import org.springframework.web.bind.annotation.*;
import com.abd3rr.applications_service.service.JobApplicationService;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin(origins = "*")
public class JobApplicationController {
    private final JobApplicationService service;

    public JobApplicationController(JobApplicationService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public JobApplicationResponse getById(@PathVariable Long id) {
        return service.findById(id);
    }


    @GetMapping
    public List<JobApplicationResponse> getAll(
            @RequestParam(value = "status", required = false) ApplicationStatus status
    ) {
        if (status != null) {
            return service.findByStatus(status);
        }
        return service.findAll();
    }

    @PostMapping
    public JobApplicationResponse create(@Valid @RequestBody JobApplicationRequest request) {
        return service.create(request);
    }
}
