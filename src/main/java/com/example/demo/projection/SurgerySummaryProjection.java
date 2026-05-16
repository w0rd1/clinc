package com.example.demo.projection;

import com.example.demo.shared.Department;
import com.example.demo.shared.Room;
import com.example.demo.shared.Staff;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface SurgerySummaryProjection {
    UUID getId();

    @Value("#{target.patient.fullName}")
    String getPatientName();
    LocalDate getSchedule();

    OperationRoomSummary getOperationRoom();
    List<MedicalStaffSummary> getMedicalStaff();

    interface OperationRoomSummary{
        Room getRoomIdentifeir();
        Department getDepartment();
    }

    interface MedicalStaffSummary{
        Staff getStaffTag();
        String getLicenseNumber();
    }
}
