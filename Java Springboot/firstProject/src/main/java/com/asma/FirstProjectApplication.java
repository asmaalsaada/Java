package com.asma;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class FirstProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstProjectApplication.class, args);
	}
@RequestMapping("/")
public String hello() {
	return "I Think it's working..!";
}
@RequestMapping("/random")
public String random() {
	return "SpringBoot is great! So easy to just respond with strings!!";
}
}
