package com.example.jobData.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OrderOperator {
    ASC("ASC"),
    DESC("DESC");

    private final String value;
}
