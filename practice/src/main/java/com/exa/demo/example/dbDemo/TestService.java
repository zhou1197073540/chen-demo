package com.exa.demo.example.dbDemo;

import com.exa.demo.example.dbDemo.mappers.TestDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    @Autowired
    TestDao testDao;
}
