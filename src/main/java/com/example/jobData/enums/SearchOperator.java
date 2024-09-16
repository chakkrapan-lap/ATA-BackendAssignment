package com.example.jobData.enums;

import com.example.jobData.exceptions.ServiceException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
public enum SearchOperator {
    EQUAL("eq"),
    LESS_THAN("lt"),
    LESS_THAN_EQUAL("lte"),
    GREATER_THAN("gt"),
    GREATER_THAN_EQUAL("gte"),
    CONTAINS("contains");

    private final String operator;

    public static SearchOperator getByValue(String value) {
        for (SearchOperator status : SearchOperator.values()) {
            if (status.getOperator().equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw new ServiceException(HttpStatus.BAD_REQUEST, "Unsupported operator: " + value);
    }

}
