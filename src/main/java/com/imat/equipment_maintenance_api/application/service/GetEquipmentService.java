package com.imat.equipment_maintenance_api.application.service;

import org.springframework.transaction.annotation.Transactional;

import com.imat.equipment_maintenance_api.domain.exception.NotFoundException;
import com.imat.equipment_maintenance_api.domain.model.Equipment;
import com.imat.equipment_maintenance_api.domain.port.in.GetEquipmentUseCase;
import com.imat.equipment_maintenance_api.domain.port.out.EquipmentRepositoryPort;

public class GetEquipmentService implements GetEquipmentUseCase {

    private final EquipmentRepositoryPort repositoryPort;

    public GetEquipmentService(EquipmentRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    @Transactional(readOnly = true)
    public Equipment getById(Long id) {
        return repositoryPort.findById(id)
                .orElseThrow(() -> new NotFoundException("Equipo no encontrado con id: " + id));
    }
}
