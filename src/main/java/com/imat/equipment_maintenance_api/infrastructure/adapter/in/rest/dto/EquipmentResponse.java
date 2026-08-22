package com.imat.equipment_maintenance_api.infrastructure.adapter.in.rest.dto;

public class EquipmentResponse {
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

    public EquipmentResponse(Long id, String equipmentName, String imageUrl, String type, String inventoryCode,
                             String brand, String model, String series, String location, String area,
                             String frequency, String floor, String tower) {
        this.id = id;
        this.equipmentName = equipmentName;
        this.imageUrl = imageUrl;
        this.type = type;
        this.inventoryCode = inventoryCode;
        this.brand = brand;
        this.model = model;
        this.series = series;
        this.location = location;
        this.area = area;
        this.frequency = frequency;
        this.floor = floor;
        this.tower = tower;
    }

    public Long getId() {
        return id;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getType() {
        return type;
    }

    public String getInventoryCode() {
        return inventoryCode;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getSeries() {
        return series;
    }

    public String getLocation() {
        return location;
    }

    public String getArea() {
        return area;
    }

    public String getFrequency() {
        return frequency;
    }

    public String getFloor() {
        return floor;
    }

    public String getTower() {
        return tower;
    }
}
