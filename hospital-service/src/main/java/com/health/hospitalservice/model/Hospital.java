package com.health.hospitalservice.model;

import jakarta.persistence.*;

@Entity(name = "t_hospital")
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(
            name = "name"
    )
    private String name;

    @Column(
            name = "current_patients"
    )
    private int currentPatients;

    @Column(
            name = "total_capacity"
    )
    private int totalCapacity;

    public Hospital() {
    }

    public Hospital(String name, int currentPatients, int totalCapacity) {
        this.name = name;
        this.currentPatients = currentPatients;
        this.totalCapacity = totalCapacity;
    }

    public Hospital(Long id, String name, int currentPatients, int totalCapacity) {
        this.id = id;
        this.name = name;
        this.currentPatients = currentPatients;
        this.totalCapacity = totalCapacity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentPatients() {
        return currentPatients;
    }

    public void setCurrentPatients(int freePlaces) {
        this.currentPatients = freePlaces;
    }

    public int getTotalCapacity() {
        return totalCapacity;
    }

    public void setTotalCapacity(int totalCapacity) {
        this.totalCapacity = totalCapacity;
    }
}
