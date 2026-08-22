package com.imat.equipment_maintenance_api.infrastructure.adapter.out.persistence.entity;

import java.time.LocalDateTime;

import com.imat.equipment_maintenance_api.domain.enums.OrderStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ordenes")
@Getter
@Setter
@NoArgsConstructor
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private MaintenanceStaffEntity maintenanceStaff;

    @ManyToOne
    @JoinColumn(name = "equipment_id")
    private EquipmentEntity equipment;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "maintenance_id")
    private MaintenanceEntity maintenance;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
