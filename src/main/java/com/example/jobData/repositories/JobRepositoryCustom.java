package com.example.jobData.repositories;

import com.example.jobData.models.entities.JobEntity;

import java.util.List;
import java.util.Map;

public interface JobRepositoryCustom {
    List<JobEntity> getJobs(Map<String,String> request);
}
