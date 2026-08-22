package com.imat.equipment_maintenance_api.infrastructure.config;

import com.imat.equipment_maintenance_api.application.service.EquipmentService;
import com.imat.equipment_maintenance_api.application.service.MaintenanceStaffService;
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
        return new EquipmentService(equipmentRepositoryPort);
    }

    @Bean
    public CreateMaintenanceStaffUseCase createMaintenanceStaffUseCase(MaintenanceStaffRepositoryPort maintenanceStaffRepositoryPort){
        return new MaintenanceStaffService(maintenanceStaffRepositoryPort);
    }
}
