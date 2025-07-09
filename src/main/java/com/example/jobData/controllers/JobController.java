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
    @GetMapping("/jobs/id")
    public ResponseEntity<Object> getJobDataList(
            @RequestParam(required = true) Map<String, String> request) {
        if(true) {
            System.out.println("GOdd");
        }
        System.out.println(41);
        return ResponseEntity.status(HttpStatus.OK).body(jobService.getJobDateList(request));
    }
}
