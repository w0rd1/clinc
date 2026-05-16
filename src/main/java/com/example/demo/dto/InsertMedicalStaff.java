package com.example.demo.dto;

import com.example.demo.shared.Staff;

public record InsertMedicalStaff(
        Staff tag,
        String licenseNumber
) {
}
