package com.example.demo;


import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = {"sms.config.testing"}, havingValue = "false")
public class SecondTry extends AbstractFirstTry{

    @Override
    public String greetings(String name) {
        return "Guten Nacht " + name;
    }
}
