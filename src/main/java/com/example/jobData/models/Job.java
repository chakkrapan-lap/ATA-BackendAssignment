package com.example.jobData.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Job {
    @JsonProperty("Timestamp")
    private String timestamp;
    @JsonProperty("Employer")
    private String employer;
    @JsonProperty("Location")
    private String location;
    @JsonProperty("Job Title")
    private String jobTitle;
    @JsonProperty("Years at Employer")
    private BigDecimal yearsAtEmployer;
    @JsonProperty("Years of Experience")
    private BigDecimal yearsOfExperience;
    @JsonProperty("Salary")
    private BigDecimal salary;
    @JsonProperty("Signing Bonus")
    private BigDecimal signingBonus;
    @JsonProperty("Annual Bonus")
    private BigDecimal annualBonus;
    @JsonProperty("Annual Stock Value/Bonus")
    private BigDecimal annualStockValueBonus;
    @JsonProperty("Gender")
    private String gender;
    @JsonProperty("Additional Comments")
    private String additionalComments;
}
