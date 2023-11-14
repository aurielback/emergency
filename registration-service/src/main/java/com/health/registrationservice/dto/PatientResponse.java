package com.health.registrationservice.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.health.registrationservice.constant.Sex;

import java.time.LocalDate;
import java.util.Objects;

public class PatientResponse {

    @JsonProperty(
            "first_name"
    )
    private String firstName;

    @JsonProperty(
            "second_name"
    )
    private String secondName;

    @JsonProperty(
            "last_name"
    )
    private String lastName;

    @JsonProperty(
            "sex"
    )
    private Sex sex;

    @JsonProperty(
            "date_of_birth"
    )
    private LocalDate dateOfBirth;

    public PatientResponse() {
    }

    public PatientResponse(String firstName, String secondName, String lastName, Sex sex, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientResponse that = (PatientResponse) o;
        return Objects.equals(firstName, that.firstName) && Objects.equals(secondName, that.secondName) && Objects.equals(lastName, that.lastName) && sex == that.sex && Objects.equals(dateOfBirth, that.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, lastName, sex, dateOfBirth);
    }
}
