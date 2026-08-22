package com.imat.equipment_maintenance_api.infrastructure.adapter.in.rest;

import com.imat.equipment_maintenance_api.domain.model.Equipment;
import com.imat.equipment_maintenance_api.domain.port.in.CreateEquipmentUseCase;
import com.imat.equipment_maintenance_api.infrastructure.adapter.in.rest.dto.CreateEquipmentRequest;
import com.imat.equipment_maintenance_api.infrastructure.adapter.in.rest.dto.EquipmentResponse;
import com.imat.equipment_maintenance_api.infrastructure.adapter.in.rest.mapper.EquipmentMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(("/api/v1/equipments"))
public class EquipmentController {

    private final CreateEquipmentUseCase createEquipmentUseCase;
    private final EquipmentMapper equipmentMapper;

    public EquipmentController(CreateEquipmentUseCase createEquipmentUseCase, EquipmentMapper equipmentMapper) {
        this.createEquipmentUseCase = createEquipmentUseCase;
        this.equipmentMapper = equipmentMapper;
    }

    @PostMapping
    public ResponseEntity<EquipmentResponse> save (@RequestBody CreateEquipmentRequest request){

        var domain = new Equipment(
                null,
                request.getEquipmentName(),
                request.getImageUrl(),
                request.getType(),
                request.getInventoryCode(),
                request.getBrand(),
                request.getModel(),
                request.getSeries(),
                request.getLocation(),
                request.getArea(),
                request.getFrequency(),
                request.getFloor(),
                request.getTower()
        );

        var created = createEquipmentUseCase.create(domain);

        return new ResponseEntity<>(equipmentMapper.toResponse(created), HttpStatus.CREATED);
    }
}
