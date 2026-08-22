package com.imat.equipment_maintenance_api.application.service;

import org.springframework.transaction.annotation.Transactional;

import com.imat.equipment_maintenance_api.domain.exception.NotFoundException;
import com.imat.equipment_maintenance_api.domain.port.in.DeleteEquipmentUseCase;
import com.imat.equipment_maintenance_api.domain.port.out.EquipmentRepositoryPort;

public class DeleteEquipmentService implements DeleteEquipmentUseCase {

    private final EquipmentRepositoryPort repositoryPort;

    public DeleteEquipmentService(EquipmentRepositoryPort repositoryPort) {
        this.repositoryPort = repositoryPort;
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        if (repositoryPort.findById(id).isEmpty()) {
            throw new NotFoundException("Equipo no encontrado con id: " + id);
        }
        repositoryPort.deleteById(id);
    }
}
