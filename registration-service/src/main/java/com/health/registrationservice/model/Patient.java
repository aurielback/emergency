package com.health.registrationservice.model;

import com.health.registrationservice.constant.Sex;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "t_patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(
            name = "first_name",
            nullable = false
    )
    private String firstName;

    @Column(
            name = "second_name",
            nullable = true
    )
    private String secondName;

    @Column(
            name = "last_name",
            nullable = false
    )
    private String lastName;

    @Column(
            name = "sex",
            nullable = false
    )
    @Enumerated(EnumType.STRING)
    private Sex sex;

    @Column(
            name = "date_of_birth",
            nullable = false
    )
    private LocalDate dateOfBirth;


    public Patient() {
    }

    public Patient(Long id, String firstName, String secondName, String lastName, Sex sex, LocalDate dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
    }

    public Patient(String firstName, String secondName, String lastName, Sex sex, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
