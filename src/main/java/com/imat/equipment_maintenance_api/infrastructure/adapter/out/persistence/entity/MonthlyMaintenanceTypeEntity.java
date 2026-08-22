package com.imat.equipment_maintenance_api.infrastructure.adapter.out.persistence.entity;

import com.imat.equipment_maintenance_api.domain.enums.MaintenanceTypeEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MonthlyMaintenanceTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MaintenanceTypeEnum maintenanceTypeEnum;

    @ManyToOne
    @JoinColumn(name = "monthly_maintenance_id")
    private MonthlyMaintenanceEntity monthlyMaintenance;

    private Integer quantity;
}
