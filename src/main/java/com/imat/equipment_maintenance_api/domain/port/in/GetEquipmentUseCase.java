package com.imat.equipment_maintenance_api.domain.port.in;

import com.imat.equipment_maintenance_api.domain.model.Equipment;

public interface GetEquipmentUseCase {

    Equipment getById(Long id);
}
