package com.example.demo.service;


import com.example.demo.dto.CreatePatientRecord;
import com.example.demo.entity.Patient;
import com.example.demo.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PatientDashboardService {

    private PatientRepository patientRepository;

    public PatientDashboardService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient toPatient(CreatePatientRecord patientRecord){
        Random random = new Random();
        int MedicalReportNumber = 100000 + random.nextInt(900000);
        final String MRN_CODE = String.valueOf(MedicalReportNumber);
        return Patient.builder()
                .fullName(patientRecord.fullName())
                .DateOfBirth(patientRecord.DateOfBirth())
                .mrn(MRN_CODE)
                .build();
    }

    public void savePatientRecord(CreatePatientRecord patientRecord){
        patientRepository.save(toPatient(patientRecord));
    }
}
