package com.exa.demo.example.dbDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/dbDemo")
public class TestController {

    @Autowired
    TestService testService;
}
