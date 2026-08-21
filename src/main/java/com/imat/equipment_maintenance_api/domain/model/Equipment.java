package com.imat.equipment_maintenance_api.domain.model;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Equipment {

    private Long id;
    private String equipmentName;
    private String imageUrl;
    private String type;
    private String inventoryCode;
    private String brand;
    private String model;
    private String series;
    private String location;
    private String area;
    private String frequency;
    private String floor;
    private String tower;

    @Builder.Default
    private List<Maintenance> maintenances = new ArrayList<>();

    @Builder.Default
    private List<MaintenanceSchedule> maintenanceSchedules = new ArrayList<>();

    @Builder.Default
    private List<Order> orderList = new ArrayList<>();
}
