package com.asma;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
	@RequestMapping("/{dojo}")
	public String index(@PathVariable ("dojo") String s0) {
		return "The " + s0 +  " is awesome!";
	}//works
	@RequestMapping("/{burbank}-dojo/")
	public String burbnk(@PathVariable ("burbank") String s1) {
		return "Burbank Dojo is located in Southern California. " ;
		
	}
	@RequestMapping("/{sanJose}/")
	public String sJ(@PathVariable ("sanJose") String s2) {
			return "SJ is the HeadCourts";
	}
}
