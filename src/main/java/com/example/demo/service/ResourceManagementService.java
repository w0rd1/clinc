package com.example.demo.service;

import com.example.demo.dto.CreateOperationRoomRecord;
import com.example.demo.dto.InsertMedicalStaff;
import com.example.demo.entity.MedicalStaff;
import com.example.demo.entity.OperationRoom;
import com.example.demo.repository.MedicalStaffRepository;
import com.example.demo.repository.OperationRoomRepository;
import org.springframework.stereotype.Service;

@Service
public class ResourceManagementService {
    private MedicalStaffRepository medicalStaffRepository;
    private OperationRoomRepository operationRoomRepository;

    public ResourceManagementService(MedicalStaffRepository medicalStaffRepository, OperationRoomRepository operationRoomRepository) {
        this.medicalStaffRepository = medicalStaffRepository;
        this.operationRoomRepository = operationRoomRepository;
    }

    public OperationRoom toOperationRoom(CreateOperationRoomRecord RoomRecord){

        return OperationRoom.builder()
                .roomIdentifeir(RoomRecord.room())
                .department(RoomRecord.department())
                .isSterilized(RoomRecord.isSterilized())
                .build();
    }

    public MedicalStaff toMedicalStaff(InsertMedicalStaff MedicalStaffRecord){

        return MedicalStaff.builder()
                .staffTag(MedicalStaffRecord.tag())
                .licenseNumber(MedicalStaffRecord.licenseNumber())
                .build();
    }

    public void saveRoom(CreateOperationRoomRecord RoomRecord){
        operationRoomRepository.save(toOperationRoom(RoomRecord));
    }

    public void saveMedicalStaff(InsertMedicalStaff MedicalStaffRecord){
        //System.out.println(toMedicalStaff(MedicalStaffRecord));
        medicalStaffRepository.save(toMedicalStaff(MedicalStaffRecord));
    }

}
