package com.example.demo.web;

import com.example.demo.IInterfaceTry;
import com.example.demo.ITry;
import com.example.demo.TryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/hello/try")
public class TryController {

    @Autowired
    ITry iTry;

    @Autowired
    IInterfaceTry iInterfaceTry;

    @GetMapping("")
    public String helloWorld(String name) {
        return this.iTry.hello("lukas");
    }

    @GetMapping(value = "hello", consumes = "application/json")
    public String getMyAgein10years(@RequestBody TryUser tryUser) {
        return this.iTry.getTheAge(tryUser.getAge());
    }

    @GetMapping(path = "hi")
    public String nameOfGirlfriend(@RequestBody TryUser tryUser) {
        String nameOfGirlfriend;
        if (tryUser.getFirstName().equals("lukas")) {
            nameOfGirlfriend = "katrin";
        } else if (tryUser.getFirstName().equals("felix")) {
            nameOfGirlfriend = "lucija";
        } else if (tryUser.getFirstName().equals("franz")) {
            nameOfGirlfriend = "alex";
        } else {
            nameOfGirlfriend = "no girlfriend";
        }

        return this.iTry.greetings(nameOfGirlfriend);
    }

    @GetMapping(path = "/itry")
    public String newAge(@RequestBody TryUser request) {
        System.out.println(request);
        return iInterfaceTry.getNameOfUser(request.getFirstName());
    }

}
