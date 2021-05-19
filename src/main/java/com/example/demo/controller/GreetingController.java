package com.example.demo.controller;

import com.example.demo.model.Greeting;
import com.example.demo.model.User;
import com.example.demo.service.IGreetingService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
	
	@Autowired
	private IGreetingService greetingService;
	
	@GetMapping({"", "/", "/home"})
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		User user = new User();
		user.setFirstName(name);
		return greetingService.addGreeting(user);
	}
	
	@GetMapping("/param/{name}")
	public Greeting greetingParam(@PathVariable String name) {
		User user = new User();
		user.setFirstName(name);
		return greetingService.addGreeting(user);
	}
	
	@PutMapping("/put/{firstName}")
	public Greeting greeting(@PathVariable String firstName,
							 @RequestParam(value = "lastName") String lastName) {
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		return greetingService.addGreeting(user);
	}
	
	@GetMapping("/find/{id}")
	public Greeting greetingall(@PathVariable long id) {
		return greetingService.getGreetingById(id);
	}
	
	@GetMapping("/find/all")
	public List<Greeting> getAllGreeting() {
		return greetingService.getAllGreeting();
	}
	
	@PutMapping("update/put/{id}")
	public Greeting updateGreetingById(@PathVariable long id,
									   @RequestParam(value = "name") String name) {
		User user = new User();
		user.setFirstName(name);
		return greetingService.updateGreetingById(id,user);
	}
	
	@GetMapping({"/delete/{id}"})
	public List<Greeting> deleteGreeting(@PathVariable long id) {
		greetingService.deleteGreetingById(id);
		return greetingService.getAllGreeting();		
	}
}
