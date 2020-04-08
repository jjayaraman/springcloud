package com.jai.springcloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;

public class BaseService {

    @Autowired
    private DiscoveryClient discoveryClient;

    public String EUREKA_CLIENT1_URI = "";

    public RestTemplate restTemplate = new RestTemplate();

    @PostConstruct
    public void init() {
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("eureka-client");
        if(serviceInstances.size() > 0) {
            EUREKA_CLIENT1_URI = serviceInstances.get(0).getUri().toString();
        }
    }
}
