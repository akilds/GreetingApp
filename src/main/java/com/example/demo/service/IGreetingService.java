package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Greeting;
import com.example.demo.model.User;

public interface IGreetingService {
	Greeting addGreeting(User user);
	Greeting getGreetingById(long id);
	List<Greeting> getAllGreeting();
	Greeting updateGreetingById(long id, User user);
	void deleteGreetingById(long id);
}
