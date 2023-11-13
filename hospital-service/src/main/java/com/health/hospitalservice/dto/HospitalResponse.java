package com.health.hospitalservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class HospitalResponse {
    @JsonProperty(
            "name"
    )
    private String name;

    @JsonProperty(
            "current_patients"
    )
    private Long current_patients;

    @JsonProperty(
            "total_capacity"
    )
    private Long totalCapacity;

    public HospitalResponse() {
    }

    public HospitalResponse(String name, Long current_patients, Long totalCapacity) {
        this.name = name;
        this.current_patients = current_patients;
        this.totalCapacity = totalCapacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCurrent_patients() {
        return current_patients;
    }

    public void setCurrent_patients(Long current_patients) {
        this.current_patients = current_patients;
    }

    public Long getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(Long totalCapacity) {
        this.totalCapacity = totalCapacity;
    }
}
