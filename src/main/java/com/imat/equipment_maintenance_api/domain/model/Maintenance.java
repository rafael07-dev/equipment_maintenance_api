package com.imat.equipment_maintenance_api.domain.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
public class Maintenance {

    private Long id;
    private Equipment equipment;
    private MaintenanceStaff maintenanceStaff;
    private LocalDateTime scheduledDate;
    private LocalDateTime startDate;
    private LocalTime startTime;
    private LocalDateTime deliveryDate;
    private LocalTime deliveryTime;
    private Duration timeUsed;
    private LocalDateTime registrationDate;
    private LocalDateTime dateOfCompletion;
    private String type;
    private String observations;
    private String staffObservations;
    private boolean done;
    private String evidenceImg;
}
