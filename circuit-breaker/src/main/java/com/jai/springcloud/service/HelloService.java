package com.jai.springcloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.stereotype.Service;

@Service
public class HelloService extends  BaseService{

    @HystrixCommand(fallbackMethod = "helloServiceFailover")
    public String helloService() {
        return restTemplate.getForObject(EUREKA_CLIENT1_URI + "/hello", String.class);
    }

    public String helloServiceFailover() {
        return "Hello from failover";
    }
}
