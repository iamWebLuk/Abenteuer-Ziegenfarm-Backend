package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRequest {

    @Autowired
    FirstNameController firstNameController;

    @Value("${name.nachname}")
    private String moxisNachname;

    @Value("${name.vorname}")
    private String moxisVorname;

    @Value("${name.enabled: false}")
    private Boolean isEnabled;


    @GetMapping("/hallo")
    public String getTheName() {
        return firstNameController.vorname;
    }

    @GetMapping("/name")
    public String getNachNameeConfig() {
        return moxisNachname;
    }
    @GetMapping("/vorname")
        public String getVornameConfig() {
            return moxisVorname;
        }
    @GetMapping("/enabled")
        public String getIsEnabled() {
        try {
            return isEnabled.toString();
        } catch (Exception e) {
            return e.toString();
        }
    }
}
