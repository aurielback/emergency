package com.microserviceshealth.notificationservice.service;

public interface EmailSenderService {

    void sendEmail(String to, String subject, String message);


}
