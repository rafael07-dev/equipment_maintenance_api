package com.imat.equipment_maintenance_api.domain.port.out;

import java.util.Optional;

import com.imat.equipment_maintenance_api.domain.model.Equipment;

public interface EquipmentRepositoryPort {

    Equipment save(Equipment equipment);

    Optional<Equipment> findById(Long id);

    void deleteById(Long id);
}
