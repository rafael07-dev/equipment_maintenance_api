package com.imat.equipment_maintenance_api.infrastructure.adapter.out.persistence.repository;

import com.imat.equipment_maintenance_api.infrastructure.adapter.out.persistence.entity.EquipmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataEquipmentRepository extends JpaRepository<EquipmentEntity, Long> {
}
