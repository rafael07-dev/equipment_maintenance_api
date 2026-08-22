package com.imat.equipment_maintenance_api.domain.service;

import com.imat.equipment_maintenance_api.domain.model.Equipment;
import com.imat.equipment_maintenance_api.domain.port.in.CreateEquipmentUseCase;
import com.imat.equipment_maintenance_api.domain.port.out.EquipmentRepositoryPort;

public class CreateEquipmentService implements CreateEquipmentUseCase {

    private final EquipmentRepositoryPort repositoryPort;

    public CreateEquipmentService(EquipmentRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    public Equipment create(Equipment equipment) {
        return repositoryPort.save(equipment);
    }
}
