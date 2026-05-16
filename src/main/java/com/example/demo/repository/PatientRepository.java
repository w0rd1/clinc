package com.example.demo.repository;

import com.example.demo.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {
    @Query("SELECT p FROM Patient p WHERE LOWER(TRIM(p.mrn)) = LOWER(TRIM(:mrn)) AND LOWER(TRIM(p.fullName)) = LOWER(TRIM(:name))")
    Optional<Patient> findFirstByMrnAndFullNameIgnoreCase(@Param("mrn") String mrn, @Param("name") String name);
}
