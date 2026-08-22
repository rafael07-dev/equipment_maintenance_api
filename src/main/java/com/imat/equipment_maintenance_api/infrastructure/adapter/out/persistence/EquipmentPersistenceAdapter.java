package com.imat.equipment_maintenance_api.infrastructure.adapter.out.persistence;

import com.imat.equipment_maintenance_api.domain.model.Equipment;
import com.imat.equipment_maintenance_api.domain.port.out.EquipmentRepositoryPort;
import com.imat.equipment_maintenance_api.infrastructure.adapter.out.persistence.repository.SpringDataEquipmentRepository;
import org.springframework.stereotype.Component;

@Component
public class EquipmentPersistenceAdapter implements EquipmentRepositoryPort {

    private final SpringDataEquipmentRepository equipmentRepository;

    public EquipmentPersistenceAdapter(SpringDataEquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }

    @Override
    public Equipment save(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }
}
