package com.health.hospitalservice.service;

import com.health.hospitalservice.dto.HospitalWithAvailableCapacity;
import com.health.hospitalservice.repository.HospitalRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class HospitalService {

    private final HospitalRepository hospitalRepository;

    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    public List<HospitalWithAvailableCapacity> findAllWithAvailableCapacity() {
        return hospitalRepository.findAllWithAvailableCapacity();
    }

}
