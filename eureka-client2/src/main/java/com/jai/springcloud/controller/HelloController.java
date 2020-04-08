package com.jai.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.util.List;

@RestController
public class HelloController extends BaseController {

    @RequestMapping(value = "/hello")
    public ResponseEntity<?> hello() {
        return restTemplate.getForEntity(EUREKA_CLIENT_BASE_URI + "/hello", String.class);
    }
}
