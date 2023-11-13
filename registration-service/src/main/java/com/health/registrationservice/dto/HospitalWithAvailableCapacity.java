package com.health.registrationservice.dto;

public class HospitalWithAvailableCapacity {

    private String name;
    private int availableCapacity;

    public HospitalWithAvailableCapacity() {
    }

    public HospitalWithAvailableCapacity(String name, int availableCapacity) {
        this.name = name;
        this.availableCapacity = availableCapacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAvailableCapacity() {
        return availableCapacity;
    }

    public void setAvailableCapacity(int availableCapacity) {
        this.availableCapacity = availableCapacity;
    }

}
