package com.example.jobData.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatUtil {
    private DateFormatUtil() {
    }

    public static LocalDateTime changeToLocalDateFormat(String timestamp) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy HH:mm:ss");
        return LocalDateTime.parse(timestamp, formatter);
    }
}
