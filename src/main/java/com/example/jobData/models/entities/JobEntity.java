package com.example.jobData.models.entities;

import com.example.jobData.enums.Gender;
import jakarta.persistence.*;
import lombok.Data;


import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity(name = "jobs")
public class JobEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String employer;
    private String location;
    private String jobTitle;
    private BigDecimal yearsAtEmployer;
    private BigDecimal yearsOfExperience;
    private BigDecimal salary;
    private BigDecimal signingBonus;
    private BigDecimal annualBonus;
    private BigDecimal annualStockValueBonus;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String additionalComments;
    private LocalDateTime timestamp;
}
