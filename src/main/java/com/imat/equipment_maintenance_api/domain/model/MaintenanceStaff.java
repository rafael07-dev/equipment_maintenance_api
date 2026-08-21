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
public class MaintenanceStaff {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String occupation;
    private boolean availability;
    private Integer maintenanceCompleted;
    private String signaturePath;

    @Builder.Default
    private List<Order> orderList = new ArrayList<>();
}
