package com.imat.equipment_maintenance_api.infrastructure.adapter.out.persistence.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MonthlyMaintenanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private MaintenanceScheduleEntity maintenanceSchedule;

    private Integer month;

    private Integer year;

    @OneToMany(mappedBy = "monthlyMaintenance", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MonthlyMaintenanceTypeEntity> maintenanceTypes = new ArrayList<>();
}
