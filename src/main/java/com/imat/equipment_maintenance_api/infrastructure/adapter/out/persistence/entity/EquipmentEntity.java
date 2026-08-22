package com.imat.equipment_maintenance_api.infrastructure.adapter.out.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "equipos")
@Getter
@Setter
@NoArgsConstructor
public class EquipmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "equipment_name", nullable = false)
    private String equipmentName;

    @Column(name = "image_url")
    private String imageUrl;

    private String type;

    @Column(name = "inventory_code", nullable = false, unique = true)
    private String inventoryCode;

    private String brand;

    private String model;

    private String series;

    private String location;

    private String area;

    private String frequency;

    private String floor;

    private String tower;
}
