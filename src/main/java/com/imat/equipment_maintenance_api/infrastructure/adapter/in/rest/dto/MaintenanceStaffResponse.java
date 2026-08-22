package com.imat.equipment_maintenance_api.infrastructure.adapter.in.rest.dto;

public class MaintenanceStaffResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String occupation;
    private boolean availability;
    private Integer maintenanceCompleted;
    private String signaturePath;

    public MaintenanceStaffResponse(Long id, String firstName, String lastName, String email, String occupation,
                                    boolean availability, Integer maintenanceCompleted, String signaturePath) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.occupation = occupation;
        this.availability = availability;
        this.maintenanceCompleted = maintenanceCompleted;
        this.signaturePath = signaturePath;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getOccupation() {
        return occupation;
    }

    public boolean isAvailability() {
        return availability;
    }

    public Integer getMaintenanceCompleted() {
        return maintenanceCompleted;
    }

    public String getSignaturePath() {
        return signaturePath;
    }
}
