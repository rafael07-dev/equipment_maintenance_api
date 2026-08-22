package com.imat.equipment_maintenance_api.infrastructure.adapter.in.rest;

import com.imat.equipment_maintenance_api.domain.port.in.CreateMaintenanceStaffUseCase;
import com.imat.equipment_maintenance_api.infrastructure.adapter.in.rest.dto.CreateMaintenanceStaffRequest;
import com.imat.equipment_maintenance_api.infrastructure.adapter.in.rest.dto.MaintenanceStaffResponse;
import com.imat.equipment_maintenance_api.infrastructure.adapter.in.rest.mapper.MaintenanceStaffMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/staff/")
public class MaintenanceStaffController {

    private final CreateMaintenanceStaffUseCase maintenanceStaffUseCase;
    private final MaintenanceStaffMapper maintenanceStaffMapper;

    public MaintenanceStaffController(CreateMaintenanceStaffUseCase maintenanceStaffUseCase, MaintenanceStaffMapper maintenanceStaffMapper) {
        this.maintenanceStaffUseCase = maintenanceStaffUseCase;
        this.maintenanceStaffMapper = maintenanceStaffMapper;
    }

    @PostMapping("create")
    public ResponseEntity<MaintenanceStaffResponse> create(@RequestBody CreateMaintenanceStaffRequest request){

        var domain = maintenanceStaffMapper.toDomain(request);

        var created = maintenanceStaffUseCase.execute(domain);

        return new ResponseEntity<>(maintenanceStaffMapper.toResponse(created), HttpStatus.CREATED);
    }

}
