package com.jai.springcloud.controller;

import com.jai.springcloud.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private HelloService helloService;

    @RequestMapping(value = "/circuit-breaker")
    public ResponseEntity<?> circuitBreaker() {
        return ResponseEntity.ok(helloService.helloService());
    }
}
