package com.health.hospitalservice.controller;

import com.health.hospitalservice.dto.HospitalWithAvailableCapacity;
import com.health.hospitalservice.service.HospitalService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/hospital")
public class HospitalController {

    private final HospitalService hospitalService;

    public HospitalController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<HospitalWithAvailableCapacity> getAllHospitalsWithAvailablecapacity() {
        return hospitalService.findAllWithAvailableCapacity();
    }

}
