package com.imat.equipment_maintenance_api.application.service;

import com.imat.equipment_maintenance_api.domain.model.MaintenanceStaff;
import com.imat.equipment_maintenance_api.domain.port.in.CreateMaintenanceStaffUseCase;
import com.imat.equipment_maintenance_api.domain.port.out.MaintenanceStaffRepositoryPort;

public class CreateMaintenanceStaffService implements CreateMaintenanceStaffUseCase {

    private final MaintenanceStaffRepositoryPort maintenanceStaffRepositoryPort;

    public CreateMaintenanceStaffService(MaintenanceStaffRepositoryPort maintenanceStaffRepositoryPort) {
        this.maintenanceStaffRepositoryPort = maintenanceStaffRepositoryPort;
    }

    @Override
    public MaintenanceStaff execute(MaintenanceStaff maintenanceStaff) {
        return maintenanceStaffRepositoryPort.save(maintenanceStaff);
    }
}
