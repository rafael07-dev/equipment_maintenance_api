package com.imat.equipment_maintenance_api.infrastructure.adapter.out.persistence;

import com.imat.equipment_maintenance_api.domain.model.MaintenanceStaff;
import com.imat.equipment_maintenance_api.domain.port.out.MaintenanceStaffRepositoryPort;
import com.imat.equipment_maintenance_api.infrastructure.adapter.out.persistence.mapper.MaintenanceStaffEntityMapper;
import com.imat.equipment_maintenance_api.infrastructure.adapter.out.persistence.repository.SpringDataMaintenanceStaffRepository;
import org.springframework.stereotype.Component;

@Component
public class MaintenanceStaffPersistenceAdapter implements MaintenanceStaffRepositoryPort {


    private final SpringDataMaintenanceStaffRepository maintenanceStaffRepository;
    private final MaintenanceStaffEntityMapper maintenanceStaffEntityMapper;

    public MaintenanceStaffPersistenceAdapter(SpringDataMaintenanceStaffRepository maintenanceStaffRepository, MaintenanceStaffEntityMapper maintenanceStaffEntityMapper) {
        this.maintenanceStaffRepository = maintenanceStaffRepository;
        this.maintenanceStaffEntityMapper = maintenanceStaffEntityMapper;
    }

    @Override
    public MaintenanceStaff save(MaintenanceStaff maintenanceStaff) {
        var saved = maintenanceStaffRepository.save(maintenanceStaffEntityMapper.toEntity(maintenanceStaff));

        return maintenanceStaffEntityMapper.toDomain(saved);
    }
}
