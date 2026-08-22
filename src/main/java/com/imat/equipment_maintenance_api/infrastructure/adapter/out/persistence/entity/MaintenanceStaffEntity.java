package com.imat.equipment_maintenance_api.infrastructure.adapter.out.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "personal_mantenimiento")
@Getter
@Setter
@NoArgsConstructor
public class MaintenanceStaffEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String firstName;

    @Column(name = "apellido", nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    private String occupation;

    private boolean availability;

    @Column(name = "mantenimientos_completados")
    private Integer maintenanceCompleted;

    @Column(name = "signature_path")
    private String signaturePath;
}
