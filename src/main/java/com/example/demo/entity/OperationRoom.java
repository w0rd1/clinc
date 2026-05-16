package com.example.demo.entity;


// UUID id, Room roomIdentifeir, Department department, boolean isSterilized.

import com.example.demo.shared.Department;
import com.example.demo.shared.Room;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.internal.IgnoreForbiddenApisErrors;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OperationRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private Room roomIdentifeir;
    @Enumerated(EnumType.STRING)
    private Department department;
    private Boolean isSterilized;

}
