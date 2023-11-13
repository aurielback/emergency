package com.health.hospitalservice.repository;

import com.health.hospitalservice.dto.HospitalWithAvailableCapacity;
import com.health.hospitalservice.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Long> {

    //projekcja
    @Query("SELECT new com.health.hospitalservice.dto.HospitalWithAvailableCapacity" +
            "(h.name, (h.totalCapacity - h.currentPatients)) FROM t_hospital h")
    List<HospitalWithAvailableCapacity> findAllWithAvailableCapacity();

}
