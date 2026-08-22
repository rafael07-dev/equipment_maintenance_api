package com.imat.equipment_maintenance_api.infrastructure.adapter.in.rest.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.imat.equipment_maintenance_api.domain.model.MaintenanceStaff;
import com.imat.equipment_maintenance_api.infrastructure.adapter.in.rest.dto.CreateMaintenanceStaffRequest;
import com.imat.equipment_maintenance_api.infrastructure.adapter.in.rest.dto.MaintenanceStaffResponse;

@Component
public class MaintenanceStaffMapper {

    public MaintenanceStaff toDomain(CreateMaintenanceStaffRequest request) {
        return MaintenanceStaff.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .occupation(request.getOccupation())
                .availability(request.isAvailability())
                .maintenanceCompleted(request.getMaintenanceCompleted())
                .signaturePath(request.getSignaturePath())
                .build();
    }

    public MaintenanceStaffResponse toResponse(MaintenanceStaff maintenanceStaff) {
        return new MaintenanceStaffResponse(
                maintenanceStaff.getId(),
                maintenanceStaff.getFirstName(),
                maintenanceStaff.getLastName(),
                maintenanceStaff.getEmail(),
                maintenanceStaff.getOccupation(),
                maintenanceStaff.isAvailability(),
                maintenanceStaff.getMaintenanceCompleted(),
                maintenanceStaff.getSignaturePath());
    }

    public List<MaintenanceStaffResponse> toResponseList(List<MaintenanceStaff> maintenanceStaff) {
        return maintenanceStaff.stream()
                .map(this::toResponse)
                .toList();
    }
}
