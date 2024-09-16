package com.example.jobData.configs;

import com.example.jobData.mappers.JobMapper;
import com.example.jobData.models.Job;
import com.example.jobData.models.entities.JobEntity;
import com.example.jobData.repositories.JobRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@AllArgsConstructor
@Component
public class JobDataConfig implements CommandLineRunner {

    private JobRepository jobRepository;

    @Override
    public void run(String... args) throws Exception {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            InputStream inputStream = getClass().getResourceAsStream("/data.json");
            List<Job> jobs = objectMapper.readValue(inputStream, new TypeReference<List<Job>>() {
            });
            List<JobEntity> jobEntities = new ArrayList<>();

            jobs.forEach(job -> {
                jobEntities.add(JobMapper.INSTANCE.toJobEntity(job));
            });

            jobRepository.saveAll(jobEntities);
            log.info("Initialized data successfully.");

        }  catch (Exception e) {
            log.error("An error occurred while initializing data", e);
        }
    }
}
