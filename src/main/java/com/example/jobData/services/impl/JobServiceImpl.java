package com.example.jobData.services.impl;

import com.example.jobData.mappers.JobMapper;
import com.example.jobData.models.dtos.JobDto;
import com.example.jobData.models.entities.JobEntity;
import com.example.jobData.repositories.JobRepositoryCustom;
import com.example.jobData.services.JobService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class JobServiceImpl implements JobService {

    private JobRepositoryCustom jobRepositoryCustom;

    @Override
    public List<JobDto> getJobDateList(Map<String, String> request) {
        List<JobEntity> jobEntities = jobRepositoryCustom.getJobs(request);
        List<JobDto> jobDtoList = new ArrayList<>();
        jobEntities.forEach(jobEntity -> {
            jobDtoList.add(JobMapper.INSTANCE.toJobDto(jobEntity));
        });
        return jobDtoList;
    }
}
