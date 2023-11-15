package com.apigateway.apigateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class ApiGatewayController {

    @GetMapping
    public String welcomeToApiGateway() {
        return "Welcome to Api Gateway!";
    }

}
