package com.jai.springcloud.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RestController
public class HelloController {

    @Value("${environment}")
    private String environment;

    @Value("${adminurl}")
    private String adminurl;

    @Value("${middlewareHome}")
    private String middlewareHome;

    @Value("${weblogicHome}")
    private String weblogicHome;

    @Value("${domainHome}")
    private String domainHome;

    private Config config = null;

    @PostConstruct
    public void init() {
        config = new Config(environment, adminurl, middlewareHome, weblogicHome, domainHome);
    }

    @RequestMapping(value = "/properties")
    public ResponseEntity<?> loadProperties() {
        return ResponseEntity.ok(config);
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Config {

    private String environment;
    private String adminurl;
    private String middlewareHome;
    private String weblogicHome;
    private String domainHome;

}
