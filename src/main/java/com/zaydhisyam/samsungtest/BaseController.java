package com.zaydhisyam.samsungtest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
    
    @GetMapping("/")
    public String index() {
        return "Welcome to REST API app build with Spring, MongoDB Atlas, and Maven!";
    }
}
