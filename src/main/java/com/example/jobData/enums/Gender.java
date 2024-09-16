package com.example.jobData.enums;

import com.example.jobData.exceptions.ServiceException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum Gender {
    MALE("Male"),
    FEMALE("Female");

    private final String value;

    public static Gender getByValue(String value) {
        for (Gender gender : Gender.values()) {
            if (gender.getValue().equalsIgnoreCase(value)) {
                return gender;
            }
        }
        throw new ServiceException(HttpStatus.BAD_REQUEST, "Unsupported gender: " + value);
    }
}
