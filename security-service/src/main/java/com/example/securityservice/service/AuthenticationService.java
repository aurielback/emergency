package com.example.securityservice.service;

import com.example.securityservice.dto.JwtAuthenticationResponse;
import com.example.securityservice.dto.RefreshTokenRequest;
import com.example.securityservice.dto.SignInRequest;
import com.example.securityservice.dto.SignUpRequest;
import com.example.securityservice.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticationService {

    public User signUp(SignUpRequest sign);
    JwtAuthenticationResponse signIn(SignInRequest signInRequest);
    JwtAuthenticationResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}
