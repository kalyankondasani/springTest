package com.spring.testing.init.springconcepts.contoller;

import com.spring.testing.init.springconcepts.models.CustomException;
import com.spring.testing.init.springconcepts.models.CustomValidator;
import com.spring.testing.init.springconcepts.models.Greeting;
import com.spring.testing.init.springconcepts.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.info.BuildProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@Slf4j
@RequestMapping(value = "/v3", produces = MediaType.APPLICATION_JSON_VALUE)
public class TestConroller {
    private CustomValidator customValidator;
    private TestService testService;

    Logger logger = LoggerFactory.getLogger(TestConroller.class);

    //this is the way to set the value from application properties
    @Value("${spring.application.name:default_value}")
    private String applicationName;

    @Value("${app.version}")
    private String buildProperties;

    @Autowired
    public TestConroller(CustomValidator customValidator, TestService testService) {
        this.customValidator = customValidator;
        this.testService = testService;
    }

    @GetMapping(value = "/testing")

    @ResponseBody
    public ResponseEntity<String> greeting(@RequestParam(value = "name", required = false) String name) throws CustomException {
        Greeting greeting = new Greeting();
        greeting.setValue(name);
        customValidator.validateRequest(greeting);
        logger.info("build version is : " + buildProperties);

        logger.info("request cmae to controller");
        String response = testService.callCommand(name);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/appName")
    @ResponseBody
    public String displayAppllicationName() throws CustomException {
        logger.info("info log");
        logger.debug("debug log");
        logger.warn("warn log");
        logger.error("error log");
        testService.callCommand("Kalyan");

        return applicationName;
    }
}
