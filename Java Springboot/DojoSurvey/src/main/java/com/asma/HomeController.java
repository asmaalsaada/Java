package com.asma;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String main(HttpSession session) {
		if (session.getAttribute("name") == null) // no curly since if is one line.. if not in session .. do... 
			return "index.jsp"; // end of if
		return "redirect:/result";
	}
	@RequestMapping("/form")
	public String form(HttpSession session,@RequestParam(value="name") String name,@RequestParam(value="dojoLoc") String location,@RequestParam(value="favLan") String language,@RequestParam(value="textBox") String text) {
		if (session.getAttribute("name") == null) {
			session.setAttribute("name", name);
			session.setAttribute("dojoLoc", location);
			session.setAttribute("favLan", language);
			session.setAttribute("textBox", text);
			String loc1 = (String) session.getAttribute(location);
			String lan1 = (String) session.getAttribute(language);
			String name1 = (String) session.getAttribute(name);
			String cmnt = (String) session.getAttribute(text);
//			model.addAttribute("location2", loc1); // no need for model
//			model.addAttribute("favLang2", lan1);
//			model.addAttribute("name2", name1);
//			model.addAttribute("cmnt2", cmnt);
			return "redirect:/result";
		} 
		return "redirect:/";
	} @RequestMapping("/result") 
	public String show(HttpSession session) {
		if (session.getAttribute("name") != null)
			return "result.jsp";
		return "redirect:/";
	}
	@RequestMapping("/back")
	public String back() {
		return "index.jsp";
	}
}