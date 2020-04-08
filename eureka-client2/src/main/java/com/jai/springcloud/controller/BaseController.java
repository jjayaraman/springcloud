package com.jai.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;

public abstract class BaseController {

    public String EUREKA_CLIENT_BASE_URI = "";

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    public RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @PostConstruct
    public void init() {
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("eureka-client");
        if(serviceInstances.size() > 0){
            EUREKA_CLIENT_BASE_URI = serviceInstances.get(0).getUri().toString();
        }
    }

}
