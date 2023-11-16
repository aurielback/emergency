package com.example.securityservice.service;

import com.example.securityservice.dto.JwtAuthenticationResponse;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

public interface JWTService {

    String extractUsername(String token);
    String generateToken(UserDetails userDetails);
    String generateRefreshToken(Map<String, Object> extraClaims, UserDetails userDetails);
    Boolean validateToken(String token, UserDetails userDetails);
}
