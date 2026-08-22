package com.imat.equipment_maintenance_api.domain.port.in;

import com.imat.equipment_maintenance_api.domain.model.MaintenanceStaff;

public interface CreateMaintenanceStaffUseCase {

    MaintenanceStaff execute(MaintenanceStaff maintenanceStaff);
}
