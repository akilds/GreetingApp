package com.example.demo.controller;

import com.example.demo.model.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {
    @RequestMapping(value = {"", "/", "/hello"})
    public String sayHello() {
        return "HelloWorld!!!";
    }

    @RequestMapping(value = ("/query"), method = RequestMethod.GET)
    public String sayHello(@RequestParam(value = "name") String firstName, @RequestParam(value = "name") String lastName) {
        return "Hello " + firstName + " " + lastName + "!!!";
    }

    @GetMapping("/param/{name}")
    public String sayHelloParam(@PathVariable String name) {
        return "Hello" + name + "!!!";
    }

    @PostMapping("/post")
    public String sayHelloPost(@RequestBody User user) {
        return "Hello" + user.getFirstName() + " " + user.getLastName();
    }

    @PutMapping("/put/{firstName}")
    public String sayHelloPut(@PathVariable String firstName, @RequestParam(value = "name") String lastName) {
        return "Hello" + firstName + " " + lastName + "!!!";
    }
}
