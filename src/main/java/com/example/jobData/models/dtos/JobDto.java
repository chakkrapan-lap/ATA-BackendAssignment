package com.example.jobData.models.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.math.BigDecimal;
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class JobDto {
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
    private String gender;
    private String additionalComments;
    private String timestamp;
}
