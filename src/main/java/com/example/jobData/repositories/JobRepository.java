package com.example.jobData.repositories;

import com.example.jobData.models.entities.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<JobEntity, Integer> {
}
