package com.asma;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	ArrayList<String> s = new ArrayList<String>();
@RequestMapping("/gold")
public String home() {
	return "index.jsp";
	}
@RequestMapping("/process_money")
	public String gold(HttpSession session, @RequestParam(value="inp") String gold, Model model ) {
//	if (session.getAttribute("farmLog")== null){
//		session.setAttribute("farmLog",);
//	}
	
	if (session.getAttribute("gold")== null){
		session.setAttribute("gold", 0);
	}
	int coin = (int)session.getAttribute("gold");
	
	if (gold.equals("farm")) {
	coin += (int)Math.floor(Math.random()*(10+1)+10);
	
	s.add("you've earned "+Integer.toString(coin) +  " in Farm");
//		session.setAttribute("farm", coin);
} 	if (gold.equals("house")) {
	 coin += (int)Math.floor(Math.random()*(5+1)+5);
	 s.add("you've earned "+Integer.toString(coin) +  " in House");
}	if (gold.equals("cave")) {
	coin += (int)Math.floor(Math.random()*(3+1)+2);
	s.add("you've earned "+Integer.toString(coin) +  " in Cave");
}	if (gold.equals("casino")) {
	coin += (int)Math.floor(Math.random()*(100+1)-50);
	s.add("you've earned/lost "+Integer.toString(coin) +  " in casino");
}
	session.setAttribute("gold",coin);	
//	s.add((String) session.getAttribute("gold")); 
//	s.add((String) session.getAttribute("gold"));
	session.setAttribute("activites", s);
//	for (int i =0; i<s.size();i++) {
//		System.out.println(s.get(i));
//	}
//	model.addAttribute();
	System.out.println(s);
	return "redirect:/gold";
}
}
