package com.imat.equipment_maintenance_api.infrastructure.adapter.in.rest.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.imat.equipment_maintenance_api.domain.model.Equipment;
import com.imat.equipment_maintenance_api.infrastructure.adapter.in.rest.dto.EquipmentResponse;

@Component
public class EquipmentMapper {

    public EquipmentResponse toResponse(Equipment equipment) {
        return new EquipmentResponse(
                equipment.getId(),
                equipment.getEquipmentName(),
                equipment.getImageUrl(),
                equipment.getType(),
                equipment.getInventoryCode(),
                equipment.getBrand(),
                equipment.getModel(),
                equipment.getSeries(),
                equipment.getLocation(),
                equipment.getArea(),
                equipment.getFrequency(),
                equipment.getFloor(),
                equipment.getTower());
    }

    public List<EquipmentResponse> toResponseList(List<Equipment> equipments) {
        return equipments.stream()
                .map(this::toResponse)
                .toList();
    }
}
