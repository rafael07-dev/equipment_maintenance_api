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
public class MaintenanceSchedule {

    private Long id;
    private Equipment equipment;
    private MaintenanceStaff responsible;

    @Builder.Default
    private List<MonthlyMaintenance> monthlyMaintenances = new ArrayList<>();
}
