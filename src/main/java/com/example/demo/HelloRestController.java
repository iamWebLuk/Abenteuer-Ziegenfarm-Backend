package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloRestController {

    TestData testData = new TestData();

    @GetMapping("/user")
    public String helloUser() {
        return "Hello User";
    }

    @GetMapping("/admin")
    public String helloAdmin() {
        return "Hello Admin";
    }

    @GetMapping(path = "/userage")
    public Integer getAgeFromUser() {

        return testData.getAge();
    }

    @PostMapping("/userage")
    public void setNewAgeForUser(@RequestBody(required = true) Integer age) {
        testData.setAge(age);
        System.out.println(testData.getAge());
    }

}
