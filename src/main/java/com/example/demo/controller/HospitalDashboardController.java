package com.example.demo.controller;


import com.example.demo.dto.CreatePatientRecord;
import com.example.demo.dto.CreateSurgeryRecord;
import com.example.demo.dto.SurgerySearchRequest;
import com.example.demo.projection.SurgerySummaryProjection;
import com.example.demo.service.PatientDashboardService;
import com.example.demo.service.SurgeryDashboardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/dashboard")
public class HospitalDashboardController {

    private SurgeryDashboardService surgeryDashboardService;
    private PatientDashboardService patientDashboardService;

    public HospitalDashboardController(
            SurgeryDashboardService surgeryDashboardService,
            PatientDashboardService patientDashboardService
    ) {
        this.surgeryDashboardService = surgeryDashboardService;
        this.patientDashboardService = patientDashboardService;
    }

    @GetMapping("summary")
    public ResponseEntity<List<SurgerySummaryProjection>> summary(@RequestBody SurgerySearchRequest request){
        var surgerySummary = surgeryDashboardService.getDashboardSurgeries(request);
        return ResponseEntity.ok(surgerySummary);
    }

    @PostMapping("/insert/patient")
    public String insertPatient(@RequestBody CreatePatientRecord patientRecord){
        patientDashboardService.savePatientRecord(patientRecord);

        return "success";
    }

    @PostMapping("/insert/surgery")
    public String insertSurgery(@RequestBody CreateSurgeryRecord surgeryRecord){
        surgeryDashboardService.saveSurgeryRecord(surgeryRecord);

        return "success";
    }

}
