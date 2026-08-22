package com.imat.equipment_maintenance_api.domain.port.in;

import com.imat.equipment_maintenance_api.domain.model.Equipment;

public interface CreateEquipmentUseCase {

    Equipment create(Equipment equipment);
}
