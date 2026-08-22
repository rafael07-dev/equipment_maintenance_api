package com.imat.equipment_maintenance_api.infrastructure.adapter.out.persistence.repository;

import com.imat.equipment_maintenance_api.domain.model.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface SpringDataEquipmentRepository extends JpaRepository<Equipment, Long> {

    Optional<Equipment> findEquipmentById(Long id);
}
