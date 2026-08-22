package com.imat.equipment_maintenance_api.infrastructure.adapter.out.persistence.repository;

import com.imat.equipment_maintenance_api.infrastructure.adapter.out.persistence.entity.MaintenanceStaffEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataMaintenanceStaffRepository extends JpaRepository<MaintenanceStaffEntity, Long> {
}
