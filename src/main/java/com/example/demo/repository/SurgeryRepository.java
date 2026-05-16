package com.example.demo.repository;

import com.example.demo.entity.Surgery;
import com.example.demo.shared.Room;
import com.example.demo.shared.Staff;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
public interface SurgeryRepository extends JpaRepository<Surgery, UUID>, JpaSpecificationExecutor<Surgery> {

    @EntityGraph(attributePaths = {"operationRoom", "medicalStaff"})
    <T> List<T> findBy(Specification<Surgery> surgery, Class<T> projectionType);

    @Query("SELECT p, r, ms FROM Patient p, OperationRoom r, MedicalStaff ms WHERE LOWER(TRIM(p.mrn)) = LOWER(TRIM(:mrn)) AND LOWER(TRIM(p.fullName)) = LOWER(TRIM(:name)) AND r.roomIdentifeir = :room AND ms.staffTag = :tag")
    List<Object[]> findSurgeryDataGraph(@Param("mrn") String mrn, @Param("name") String name, @Param("room") Room room, @Param("tag") Staff tag);
}
