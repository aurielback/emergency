package com.microserviceshealth.notificationservice.controller;

import com.microserviceshealth.notificationservice.dto.EmailMessage;
import com.microserviceshealth.notificationservice.service.EmailSenderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class NotificationController {

    private final EmailSenderService emailSenderService;

    public NotificationController(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @PostMapping("/send-email")
    public ResponseEntity sendEmail(@RequestBody EmailMessage email) {
        emailSenderService.sendEmail(email.getTo(), email.getSubject(), email.getText());
        return ResponseEntity.ok("Send email successfully");
    }
}
