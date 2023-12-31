package com.health.registrationservice.repository;

import com.health.registrationservice.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<Patient, Long> {

}
