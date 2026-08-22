package com.imat.equipment_maintenance_api.infrastructure.adapter.out.persistence.mapper;

import org.springframework.stereotype.Component;

import com.imat.equipment_maintenance_api.domain.model.MaintenanceStaff;
import com.imat.equipment_maintenance_api.infrastructure.adapter.out.persistence.entity.MaintenanceStaffEntity;

@Component
public class MaintenanceStaffEntityMapper {

    public MaintenanceStaff toDomain(MaintenanceStaffEntity entity) {
        return MaintenanceStaff.builder()
                .id(entity.getId())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .email(entity.getEmail())
                .occupation(entity.getOccupation())
                .availability(entity.isAvailability())
                .maintenanceCompleted(entity.getMaintenanceCompleted())
                .signaturePath(entity.getSignaturePath())
                .build();
    }

    public MaintenanceStaffEntity toEntity(MaintenanceStaff domain) {
        MaintenanceStaffEntity entity = new MaintenanceStaffEntity();
        entity.setId(domain.getId());
        entity.setFirstName(domain.getFirstName());
        entity.setLastName(domain.getLastName());
        entity.setEmail(domain.getEmail());
        entity.setOccupation(domain.getOccupation());
        entity.setAvailability(domain.isAvailability());
        entity.setMaintenanceCompleted(domain.getMaintenanceCompleted());
        entity.setSignaturePath(domain.getSignaturePath());
        return entity;
    }
}
