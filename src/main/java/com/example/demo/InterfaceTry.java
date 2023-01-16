package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class InterfaceTry implements IInterfaceTry{
    @Override
    public String getNameOfUser(String name) {
        return "hallo " + name;
    }

    @Override
    public String getAgeFromUser(Integer age) {
        return " " + age;
    }
}
