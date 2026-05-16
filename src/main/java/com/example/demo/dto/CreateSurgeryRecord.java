package com.example.demo.dto;

import com.example.demo.shared.Room;
import com.example.demo.shared.Staff;
import com.example.demo.shared.SurgeryStatus;

import java.time.LocalDate;
import java.time.LocalTime;

public record CreateSurgeryRecord(
        String name,
        String mrn,
        LocalDate schedule,
        LocalTime time,
        Staff tag,
        Room room,
        SurgeryStatus status
) {
}
