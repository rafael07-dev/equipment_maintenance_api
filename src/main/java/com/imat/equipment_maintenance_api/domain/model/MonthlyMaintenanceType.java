package com.imat.equipment_maintenance_api.domain.model;

import com.imat.equipment_maintenance_api.domain.enums.MaintenanceTypeEnum;

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
public class MonthlyMaintenanceType {

    private Long id;
    private MaintenanceTypeEnum maintenanceTypeEnum;
    private MonthlyMaintenance monthlyMaintenance;
    private Integer quantity;
}
