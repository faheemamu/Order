package com.order.controller;

import com.order.entity.order;
import com.order.service.orderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
public class OrderController {

    @Autowired
    private orderServiceImpl orderService;

    @GetMapping("/summary-report")
    public order getOrderSummary() {
        return orderService.getCount();
    }
}