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
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cronograma")
@Getter
@Setter
@NoArgsConstructor
public class MaintenanceScheduleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "equipment_id")
    private EquipmentEntity equipment;

    @ManyToOne
    @JoinColumn(name = "responsible_id")
    private MaintenanceStaffEntity responsible;

    @OneToMany(mappedBy = "maintenanceSchedule", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MonthlyMaintenanceEntity> monthlyMaintenances = new ArrayList<>();
}
