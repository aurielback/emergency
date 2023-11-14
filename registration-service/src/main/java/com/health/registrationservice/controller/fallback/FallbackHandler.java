package com.health.registrationservice.controller.fallback;

import com.health.registrationservice.dto.PatientRequest;

import java.util.concurrent.CompletableFuture;

public class FallbackHandler {

    public static CompletableFuture<String> fallbackMethod(PatientRequest orderRequest, RuntimeException runtimeException) {
        return CompletableFuture.supplyAsync(() -> "Somethink went wrong, try again later!");
    }
}
