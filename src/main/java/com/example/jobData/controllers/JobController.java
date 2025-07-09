package com.example.jobData.controllers;

import com.example.jobData.services.JobService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class JobController {
    private JobService jobService;
    @GetMapping("/jobs")
    public ResponseEntity<Object> getJobDataList(
            @RequestParam(required = false) Map<String, String> request) {
        return ResponseEntity.status(HttpStatus.OK).body(jobService.getJobDateList(request));
    }
}
