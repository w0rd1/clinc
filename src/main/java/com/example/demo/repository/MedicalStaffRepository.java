package com.example.demo.repository;


import com.example.demo.entity.MedicalStaff;
import com.example.demo.shared.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;
import java.util.UUID;

@Repository
public interface MedicalStaffRepository extends JpaRepository<MedicalStaff, UUID> {
    Set<MedicalStaff> findAllByStaffTag(Staff staffTag);
}
