package com.asma;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Coding")
public class CodingController {
	@RequestMapping("")
	public String hello() {
		return "Hello Coding Dojo!";
	}
	@RequestMapping("/python")
	public String snake() {
		return "Python/Django was awesome!";
	}
	@RequestMapping("/java")
	public String coffeeJava() {
		return "Java/Spring is better!";
	}
	
}
