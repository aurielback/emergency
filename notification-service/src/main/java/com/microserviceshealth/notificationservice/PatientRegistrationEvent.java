package com.microserviceshealth.notificationservice;

public class PatientRegistrationEvent {
    private String firstName;

    public PatientRegistrationEvent() {
    }

    public PatientRegistrationEvent(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
