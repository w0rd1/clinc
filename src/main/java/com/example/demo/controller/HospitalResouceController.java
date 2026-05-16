package com.example.demo.controller;


import com.example.demo.dto.CreateOperationRoomRecord;
import com.example.demo.dto.InsertMedicalStaff;
import com.example.demo.service.ResourceManagementService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/resource")
public class HospitalResouceController {
    private ResourceManagementService resourceManagementService;

    public HospitalResouceController(ResourceManagementService resourceManagementService) {
        this.resourceManagementService = resourceManagementService;
    }

    @PostMapping("/room")
    public String insertRoom(@RequestBody CreateOperationRoomRecord RoomRecord){
        resourceManagementService.saveRoom(RoomRecord);

        return "success";
    }

    @PostMapping("/staff")
    public String insertMedicalStaff(@RequestBody InsertMedicalStaff insertMedicalStaff){
        resourceManagementService.saveMedicalStaff(insertMedicalStaff);

        return "success";
    }
}
