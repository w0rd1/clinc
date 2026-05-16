package com.example.demo.dto;

import com.example.demo.shared.Department;
import com.example.demo.shared.Room;

public record CreateOperationRoomRecord(
        Room room,
        Department department,
        Boolean isSterilized
) {
}
