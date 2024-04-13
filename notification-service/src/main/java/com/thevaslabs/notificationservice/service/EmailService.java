package com.thevaslabs.notificationservice.service;

import com.thevaslabs.notificationservice.domain.Order;

public interface EmailService {

    boolean sendEmail(Order order);
}
