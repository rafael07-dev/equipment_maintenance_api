package com.imat.equipment_maintenance_api.infrastructure.adapter.out.persistence.entity;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "mantenimientos")
@Getter
@Setter
@NoArgsConstructor
public class MaintenanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "equipment_id")
    private EquipmentEntity equipment;

    @ManyToOne
    @JoinColumn(name = "staff_id")
    private MaintenanceStaffEntity maintenanceStaff;

    @Column(name = "scheduled_date")
    private LocalDateTime scheduledDate;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "start_time")
    private LocalTime startTime;

    @Column(name = "delivery_date")
    private LocalDateTime deliveryDate;

    @Column(name = "delivery_time")
    private LocalTime deliveryTime;

    @Column(name = "time_used")
    private Duration timeUsed;

    @Column(name = "registration_date")
    private LocalDateTime registrationDate;

    @Column(name = "date_of_completion")
    private LocalDateTime dateOfCompletion;

    private String type;

    private String observations;

    @Column(name = "staff_observations")
    private String staffObservations;

    private boolean done;

    @Column(name = "evidence_img")
    private String evidenceImg;
}
