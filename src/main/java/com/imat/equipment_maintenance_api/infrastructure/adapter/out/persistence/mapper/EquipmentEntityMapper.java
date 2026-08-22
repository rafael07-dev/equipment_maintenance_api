package com.imat.equipment_maintenance_api.infrastructure.adapter.out.persistence.mapper;

import org.springframework.stereotype.Component;

import com.imat.equipment_maintenance_api.domain.model.Equipment;
import com.imat.equipment_maintenance_api.infrastructure.adapter.out.persistence.entity.EquipmentEntity;

@Component
public class EquipmentEntityMapper {

    public Equipment toDomain(EquipmentEntity entity) {
        return new Equipment(
                entity.getId(),
                entity.getEquipmentName(),
                entity.getImageUrl(),
                entity.getType(),
                entity.getInventoryCode(),
                entity.getBrand(),
                entity.getModel(),
                entity.getSeries(),
                entity.getLocation(),
                entity.getArea(),
                entity.getFrequency(),
                entity.getFloor(),
                entity.getTower());
    }

    public EquipmentEntity toEntity(Equipment equipment) {
        EquipmentEntity entity = new EquipmentEntity();
        entity.setId(equipment.getId());
        entity.setEquipmentName(equipment.getEquipmentName());
        entity.setImageUrl(equipment.getImageUrl());
        entity.setType(equipment.getType());
        entity.setInventoryCode(equipment.getInventoryCode());
        entity.setBrand(equipment.getBrand());
        entity.setModel(equipment.getModel());
        entity.setSeries(equipment.getSeries());
        entity.setLocation(equipment.getLocation());
        entity.setArea(equipment.getArea());
        entity.setFrequency(equipment.getFrequency());
        entity.setFloor(equipment.getFloor());
        entity.setTower(equipment.getTower());
        return entity;
    }
}
