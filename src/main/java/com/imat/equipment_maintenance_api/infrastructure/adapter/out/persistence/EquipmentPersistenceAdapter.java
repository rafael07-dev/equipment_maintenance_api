package com.imat.equipment_maintenance_api.infrastructure.adapter.out.persistence;

import com.imat.equipment_maintenance_api.domain.model.Equipment;
import com.imat.equipment_maintenance_api.domain.port.out.EquipmentRepositoryPort;
import com.imat.equipment_maintenance_api.infrastructure.adapter.out.persistence.entity.EquipmentEntity;
import com.imat.equipment_maintenance_api.infrastructure.adapter.out.persistence.mapper.EquipmentEntityMapper;
import com.imat.equipment_maintenance_api.infrastructure.adapter.out.persistence.repository.SpringDataEquipmentRepository;
import org.springframework.stereotype.Component;

@Component
public class EquipmentPersistenceAdapter implements EquipmentRepositoryPort {

    private final SpringDataEquipmentRepository equipmentRepository;
    private final EquipmentEntityMapper equipmentEntityMapper;

    public EquipmentPersistenceAdapter(SpringDataEquipmentRepository equipmentRepository,
                                       EquipmentEntityMapper equipmentEntityMapper) {
        this.equipmentRepository = equipmentRepository;
        this.equipmentEntityMapper = equipmentEntityMapper;
    }

    @Override
    public Equipment save(Equipment equipment) {
        EquipmentEntity saved = equipmentRepository.save(equipmentEntityMapper.toEntity(equipment));
        return equipmentEntityMapper.toDomain(saved);
    }
}
