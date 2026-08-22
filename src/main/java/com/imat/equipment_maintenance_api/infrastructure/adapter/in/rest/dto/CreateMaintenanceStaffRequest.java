package com.imat.equipment_maintenance_api.infrastructure.adapter.in.rest.dto;

public class CreateMaintenanceStaffRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String occupation;
    private boolean availability;
    private Integer maintenanceCompleted;
    private String signaturePath;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public Integer getMaintenanceCompleted() {
        return maintenanceCompleted;
    }

    public void setMaintenanceCompleted(Integer maintenanceCompleted) {
        this.maintenanceCompleted = maintenanceCompleted;
    }

    public String getSignaturePath() {
        return signaturePath;
    }

    public void setSignaturePath(String signaturePath) {
        this.signaturePath = signaturePath;
    }
}
