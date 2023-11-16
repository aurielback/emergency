package com.example.securityservice.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Repository;

@Repository
public interface UserService {

    public UserDetailsService userDetailsService();
}
