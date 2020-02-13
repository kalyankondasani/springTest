package com.spring.testing.init.springconcepts.contoller;

import com.spring.testing.init.springconcepts.models.CustomException;
import com.spring.testing.init.springconcepts.models.CustomValidator;
import com.spring.testing.init.springconcepts.models.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/v3", produces = MediaType.APPLICATION_JSON_VALUE)
public class TestConroller {
    private CustomValidator customValidator;

    @Autowired
    public TestConroller(CustomValidator customValidator) {
        this.customValidator = customValidator;
    }

    @GetMapping(value = "/testing")

    @ResponseBody
    public ResponseEntity<Greeting> greeting(@RequestParam(value = "name", required = false) String name) throws CustomException {
        Greeting greeting = new Greeting();
        greeting.setValue(name);
        customValidator.validateRequest(greeting);
        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }
}
