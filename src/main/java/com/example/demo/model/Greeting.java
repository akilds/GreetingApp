package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="GREETINGS")
public class Greeting {
	
	@Id
	private long id;
	private String message;
	
	public Greeting() {
		id = 0;
		message = "";
	}
	public Greeting(long id, String message) {
		this.id = id;
		this.message = message;
	}
	
	public long getId() {
		return id;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
