package com.example.demo.entity;


// UUID id, Patient patient, DateRange schedule, SurgeryStatus status.

// @ManyToOne(fetch = FetchType.LAZY) -> OperatingRoom
// @ManyToMany(fetch = FetchType.LAZY) -> Set<MedicalStaff>

import com.example.demo.shared.SurgeryStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Surgery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;


    private LocalDate schedule;
    private LocalTime time;
    @Enumerated(EnumType.STRING)
    private SurgeryStatus status;

    @ManyToOne
    private OperationRoom operationRoom;

    @ManyToMany
    private Set<MedicalStaff> medicalStaff;

    @ManyToOne
    @JoinColumn(name = "patient_Id")
    private Patient patient;

}
