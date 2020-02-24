package com.spring.testing.init.springconcepts.service;

import com.spring.testing.init.springconcepts.command.TestCommand;
import com.spring.testing.init.springconcepts.contoller.TestConroller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class TestService {

    private TestCommand testCommand;
    Logger logger = LoggerFactory.getLogger(TestConroller.class);
    public TestService(TestCommand testCommand) {
        this.testCommand = testCommand;
    }

    public String callCommand(String param){
        String response = testCommand.execute(param);
        logger.info("service level log");
        return response;
    }
}
