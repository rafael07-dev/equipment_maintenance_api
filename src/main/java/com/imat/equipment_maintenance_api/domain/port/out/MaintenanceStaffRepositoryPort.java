package com.imat.equipment_maintenance_api.domain.port.out;

import com.imat.equipment_maintenance_api.domain.model.MaintenanceStaff;

public interface MaintenanceStaffRepositoryPort {
    MaintenanceStaff save(MaintenanceStaff maintenanceStaff);
}
