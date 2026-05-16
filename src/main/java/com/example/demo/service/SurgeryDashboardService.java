package com.example.demo.service;

import com.example.demo.dto.CreateSurgeryRecord;
import com.example.demo.dto.SurgerySearchRequest;
import com.example.demo.entity.MedicalStaff;
import com.example.demo.entity.OperationRoom;
import com.example.demo.entity.Patient;
import com.example.demo.projection.SurgerySummaryProjection;
import com.example.demo.entity.Surgery;
import com.example.demo.repository.MedicalStaffRepository;
import com.example.demo.repository.OperationRoomRepository;
import com.example.demo.repository.PatientRepository;
import com.example.demo.repository.SurgeryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

@Service
public class SurgeryDashboardService {

    private SurgeryRepository surgeryRepository;
    public SurgeryDashboardService(
            SurgeryRepository surgeryRepository
    ) {
        this.surgeryRepository = surgeryRepository;
    }

    public List<SurgerySummaryProjection> getDashboardSurgeries(SurgerySearchRequest request){
        Specification<Surgery> surgerySummary = Specification.
                where(SearchLogic.hasPatientName(request.patientName()))
                .and(SearchLogic.Within(request.startDate(), request.endDate()));

        List<SurgerySummaryProjection> surgeries = surgeryRepository.findBy(surgerySummary, SurgerySummaryProjection.class);

        return surgeries;
    }

    // Specification that search for
    // 1- MRN+FULLNAME
    // 2- staffTag
    // 3- room_type
    private Surgery toSurgery(CreateSurgeryRecord surgeryRecord){
        List<Object[]> dataGraph = surgeryRepository.findSurgeryDataGraph(
                surgeryRecord.mrn(),
                surgeryRecord.name(),
                surgeryRecord.room(),
                surgeryRecord.tag()
        );

        if (dataGraph.isEmpty()) {
            throw new EntityNotFoundException("Patient, Room, or Medical Staff not found with the given details");
        }

        Patient patient = (Patient) dataGraph.get(0)[0];
        OperationRoom room = (OperationRoom) dataGraph.get(0)[1];
        Set<MedicalStaff> medicalStaffSet = dataGraph.stream()
                .map(row -> (MedicalStaff) row[2])
                .collect(java.util.stream.Collectors.toSet());

        return Surgery.builder()
                .medicalStaff(medicalStaffSet)
                .patient(patient)
                .operationRoom(room)
                .schedule(surgeryRecord.schedule())
                .time(surgeryRecord.time())
                .status(surgeryRecord.status())
                .build();
    }

    public void saveSurgeryRecord(CreateSurgeryRecord surgeryRecord){
        surgeryRepository.save(toSurgery(surgeryRecord));
    }
}
