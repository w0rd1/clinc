package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record SurgerySearchRequest(
        String patientName,
        @JsonFormat(pattern = "MM-dd-yyyy")
        LocalDate startDate,
        @JsonFormat(pattern = "MM-dd-yyyy")
        LocalDate endDate
) {
}
