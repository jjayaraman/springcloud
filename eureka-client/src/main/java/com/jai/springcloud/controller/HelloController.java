package com.jai.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    DiscoveryClient discoveryClient;


    @RequestMapping(value = "/hello")
    public ResponseEntity<?> hello() {
        System.out.println("description:" + discoveryClient.description());
        System.out.println("getOrder:" + discoveryClient.getOrder());
        System.out.println("getServices:" + discoveryClient.getServices());
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("eureka-client");
        for (ServiceInstance serviceInstance : serviceInstances) {
            System.out.println("Scheme:" + serviceInstance.getScheme());
            System.out.println("Host:" + serviceInstance.getHost());
            System.out.println("Port:" + serviceInstance.getPort());
            System.out.println("InstanceId:" + serviceInstance.getInstanceId());
            System.out.println("ServiceId:" + serviceInstance.getServiceId());
            System.out.println("Uri:" + serviceInstance.getUri());
            System.out.println("isSecure:" + serviceInstance.isSecure());
            System.out.println("Metadata:" + serviceInstance.getMetadata());
            System.out.println("************************");
        }

        return ResponseEntity.ok(serviceInstances);
    }

    @RequestMapping(value = "/one")
    public ResponseEntity<?> one() {
        return ResponseEntity.ok("one");
    }

    @RequestMapping(value = "/two")
    public ResponseEntity<?> two() {
        return ResponseEntity.ok("two");
    }

    @RequestMapping(value = "/three")
    public ResponseEntity<?> three() {
        return ResponseEntity.ok("three");
    }

    @RequestMapping(value = "/four")
    public ResponseEntity<?> four() {
        return ResponseEntity.ok("four");
    }
}
