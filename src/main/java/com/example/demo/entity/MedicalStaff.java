package com.example.demo.entity;


// UUID id, Staff staffTag, String role (e.g., Surgeon, Nurse), String licenseNumber

import com.example.demo.shared.Staff;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedicalStaff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name = "staffTag")
    private Staff staffTag;

    @Column(name = "license_number")
    private String licenseNumber;
}
