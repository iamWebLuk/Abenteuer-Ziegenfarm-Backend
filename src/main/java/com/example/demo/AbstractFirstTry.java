package com.example.demo;

public abstract class AbstractFirstTry implements ITry{

    public String hello(String name) {
        return "Hello " + name;
    }

    @Override
    public String getTheAge(int age) {
        return "Your age is " + age;
    }
}
