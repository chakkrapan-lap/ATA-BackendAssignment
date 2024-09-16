package com.example.jobData.services;

import com.example.jobData.models.dtos.JobDto;

import java.util.List;
import java.util.Map;

public interface JobService {
    List<JobDto> getJobDateList(Map<String,String> request);
}
