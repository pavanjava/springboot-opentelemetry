package com.thevaslabs.notificationservice.controller;

import com.thevaslabs.notificationservice.domain.Order;
import com.thevaslabs.notificationservice.service.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping(value = "/email-notify")
    public ResponseEntity<Boolean> deductInventory(@RequestBody Order order) {
        return ResponseEntity.ok(emailService.sendEmail(order));
    }
}
