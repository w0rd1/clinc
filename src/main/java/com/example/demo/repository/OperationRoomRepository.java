package com.example.demo.repository;

import com.example.demo.entity.OperationRoom;
import com.example.demo.shared.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OperationRoomRepository extends JpaRepository<OperationRoom, UUID> {
    OperationRoom findFirstByRoomIdentifeir(Room roomIdentifeir);
}
