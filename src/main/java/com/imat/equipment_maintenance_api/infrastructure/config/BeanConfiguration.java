package com.imat.equipment_maintenance_api.infrastructure.config;

import com.imat.equipment_maintenance_api.application.service.CreateEquipmentService;
import com.imat.equipment_maintenance_api.application.service.CreateMaintenanceStaffService;
import com.imat.equipment_maintenance_api.domain.port.in.CreateEquipmentUseCase;
import com.imat.equipment_maintenance_api.domain.port.in.CreateMaintenanceStaffUseCase;
import com.imat.equipment_maintenance_api.domain.port.out.EquipmentRepositoryPort;
import com.imat.equipment_maintenance_api.domain.port.out.MaintenanceStaffRepositoryPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public CreateEquipmentUseCase createEquipmentUseCase(EquipmentRepositoryPort equipmentRepositoryPort) {
        return new CreateEquipmentService(equipmentRepositoryPort);
    }

    @Bean
    public CreateMaintenanceStaffUseCase createMaintenanceStaffUseCase(MaintenanceStaffRepositoryPort maintenanceStaffRepositoryPort){
        return new CreateMaintenanceStaffService(maintenanceStaffRepositoryPort);
    }
}
