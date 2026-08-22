package com.imat.equipment_maintenance_api.domain.port.out;

import com.imat.equipment_maintenance_api.domain.model.Equipment;

public interface EquipmentRepositoryPort {

    Equipment save(Equipment equipment);
}
