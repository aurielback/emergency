package com.health.registrationservice.controller;

import com.health.registrationservice.controller.fallback.FallbackHandler;
import com.health.registrationservice.dto.PatientRequest;
import com.health.registrationservice.dto.PatientResponse;
import com.health.registrationservice.service.RegistrationService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/registration")
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @CircuitBreaker(name = "hospital", fallbackMethod = "fallbackMethod")
    @TimeLimiter(name = "hospital")
    @Retry(name = "hospital")
    public CompletableFuture<String> registerPatient(@RequestBody PatientRequest patientRequest) {
        return CompletableFuture.supplyAsync(() -> registrationService.registerClient(patientRequest));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PatientResponse> getAllPatients() {
        return registrationService.getAllPatients();
    }
}
