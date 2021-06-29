package com.codingdojo.event.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.event.models.Comment;
import com.codingdojo.event.models.Event;
import com.codingdojo.event.models.User;
import com.codingdojo.event.services.AppService;

@Controller
public class EventController {
	private final AppService appService;

	public EventController(AppService appService) {
		super();
		this.appService = appService;
	}

	@GetMapping("/events") // should be
	public String eventsPage(HttpSession session, Model model, @ModelAttribute("Event") Event event) {
		if (session.getAttribute("userId") == null) { // notLogged()
			return "redirect:/registration";
		}
		Long id = (Long) session.getAttribute("userId");
		User u = appService.findUserById(id); //it got the user who's signed in 
		model.addAttribute("userId", u);// passed to the front end
		ArrayList<Event> evntsInState = appService.EvntInState(u.getState());
		ArrayList<Event> evntsNotInState = appService.EvntNotInState(u.getState());
		model.addAttribute("evntsInState", evntsInState);
		model.addAttribute("evntsNotInState", evntsNotInState);
		
		return "events.jsp";
	}
	// get user from session, save them in the model and return the events page

	@PostMapping("/events/new")
	public String newEvent(@Valid @ModelAttribute("Event") Event event, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "events.jsp";
		} else {
			appService.createEvnt(event);
			return "redirect:/events";
		}
	}
	@RequestMapping("/events/{id}/join/")
	public String joinEvent(@PathVariable("id") Long eventId,HttpSession session){
		Long userId = (Long)session.getAttribute("userId");
		User u = appService.findUserById(userId); //get User in session's id 
		Event e  = (Event)appService.findEvnt(eventId); //get event id
		
		List<User> eventUsers  = e.getUsers(); //list of event's users
		eventUsers.add(u); //add the signed in user to the list of the event's list of users
		
		appService.updateEvnt(e); //save changes on event
		return "redirect:/events/"; //redirects to same page
	}
	@GetMapping("/events/{id}")
	public String showEvent(@PathVariable("id")Long id ,@ModelAttribute("Message")Comment comment,Model model,HttpSession session) {
		if (session.getAttribute("userId") == null) { // notLogged()
			return "redirect:/registration";
		}
		Long uId = (Long) session.getAttribute("userId");
		User u = appService.findUserById(uId); //it got the user who's signed in 
		model.addAttribute("userId", u);
		model.addAttribute("event", appService.findEvnt(id));
		return "showEvent.jsp";
	}
	@PostMapping("/events/{message.id}/messages/new")
	public String writeMsg(@PathVariable("message.id")Long id,@Valid @ModelAttribute("Message")Comment comment,BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "showEvent.jsp";
		} else {
			Event e = appService.findEvnt(id);
			comment.setEvent_text(e);
			//comment.setUser_text((User)session.getAttribute("userId")); instead of passing as a hidden method 
			appService.createMsg(comment);
			return "redirect:/events/"+id;
		}
	}
	@GetMapping("events/{id}/edit")
	public String Edit(@PathVariable("id") Long id, HttpSession session, Model model) {
		Long userId = (Long) session.getAttribute("userId");
		Event event = this.appService.findEvnt(id);
		if(userId == null)
			return "redirect:/events";
		if(event == null || !event.getHost().getId().equals(userId))
			return "redirect:/events";
		
		model.addAttribute("event", event);
		
		model.addAttribute("userId", userId);
		return "editEvent.jsp";
	}
	@PutMapping("/events/{id}/edit")
	public String Update(@Valid @ModelAttribute("event") Event event, BindingResult result, @PathVariable("id") Long id, HttpSession session, Model model) {
		if(result.hasErrors()) {
			Long userId = (Long) session.getAttribute("userId");
			model.addAttribute("event", event);
			model.addAttribute("userId", userId);
			return "editEvent.jsp";
		}
		appService.updateEvnt(event);
		return "redirect:/events";
	}
	@DeleteMapping("/events/{id}/delete")
	public String Delete(@PathVariable("id") Long id) {
		appService.destroyEvnt(id);
		return "redirect:/events";
	}
}