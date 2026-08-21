package com.imat.equipment_maintenance_api.domain.model;

import java.time.LocalDateTime;

import com.imat.equipment_maintenance_api.domain.enums.OrderStatus;

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
public class Order {

    private Long id;
    private LocalDateTime creationDate;
    private MaintenanceStaff maintenanceStaff;
    private Equipment equipment;
    private Maintenance maintenance;
    private OrderStatus status;
}
