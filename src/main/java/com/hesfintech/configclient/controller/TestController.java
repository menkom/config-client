package com.hesfintech.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class TestController {

    @Value("${application.customer}")
    private String customer;

    @GetMapping(value = "/customer", produces = MediaType.TEXT_PLAIN_VALUE)
    public String getCustomer() {
        return String.format("Current customer is %s.", customer);
    }
}
