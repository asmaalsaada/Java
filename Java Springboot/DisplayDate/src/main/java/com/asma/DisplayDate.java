package com.asma;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DisplayDate {
	@RequestMapping("")
	public String home() {
		return "index.jsp";
	}
	@RequestMapping("/date")
	public String date(Model model) {
		Date d = new java.util.Date();
		SimpleDateFormat formatter = new SimpleDateFormat("E, 'the' dd 'of' MMMM yyyy");
		model.addAttribute("theDate", formatter.format(d));
		return "Date.jsp";
	}
	@RequestMapping("/time")
	public String time(Model model) {
		Date t = new java.util.Date();
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm a");
		model.addAttribute("theTime", formatter.format(t));
		return "Time.jsp";
	}
}
