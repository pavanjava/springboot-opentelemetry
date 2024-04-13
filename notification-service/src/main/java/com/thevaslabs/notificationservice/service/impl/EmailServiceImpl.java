package com.thevaslabs.notificationservice.service.impl;

import com.thevaslabs.notificationservice.domain.Order;
import com.thevaslabs.notificationservice.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailServiceImpl implements EmailService {
    @Override
    public boolean sendEmail(Order order) {
      log.info("Sending email for order {}", order.orderId());
      return true;
    }
}
