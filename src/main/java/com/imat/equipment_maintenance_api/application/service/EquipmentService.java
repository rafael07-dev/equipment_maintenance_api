package com.imat.equipment_maintenance_api.application.service;

import com.imat.equipment_maintenance_api.domain.model.Equipment;
import com.imat.equipment_maintenance_api.domain.port.in.CreateEquipmentUseCase;
import com.imat.equipment_maintenance_api.domain.port.out.EquipmentRepositoryPort;
import org.springframework.transaction.annotation.Transactional;

public class EquipmentService implements CreateEquipmentUseCase {

    private final EquipmentRepositoryPort repositoryPort;

    public EquipmentService(EquipmentRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    @Transactional
    public Equipment create(Equipment equipment) {
        return repositoryPort.save(equipment);
    }
}
