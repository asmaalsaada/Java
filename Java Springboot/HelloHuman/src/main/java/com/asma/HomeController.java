package com.asma;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/your_server")
public class HomeController {
	@RequestMapping("")
public String hello(){
	return "Hello Human!\n Welcome to SpringBoot!";	
	}
	@RequestMapping("/")
	public String human(@RequestParam(value="name", required=false) String searchQuery){
		if (searchQuery == null) {
			return "You've searched nothing!!";
		} else {
			return "You searched for : " + searchQuery;
		} 	
}
}
