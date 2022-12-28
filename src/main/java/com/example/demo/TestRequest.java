package com.example.demo;

import com.example.demo.Student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;

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

    @PutMapping("/changeName")
   public HttpStatus changeName(@RequestParam String name, @RequestParam LocalDate date, Integer id) {
        if (name.isEmpty() || id == 2) {
            return HttpStatus.FORBIDDEN;
        }
        return HttpStatus.OK;
    }
}

