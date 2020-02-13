package com.spring.testing.init.springconcepts.models;

import javax.validation.constraints.NotNull;


public class Greeting {
    @NotNull
    private String value;
    @NotNull
    private String intValue;


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getIntValue() {
        return intValue;
    }

    public void setIntValue(String intValue) {
        this.intValue = intValue;
    }
}
