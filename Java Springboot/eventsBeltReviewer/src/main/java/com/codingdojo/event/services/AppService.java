package com.codingdojo.event.services;

import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.codingdojo.event.models.Comment;
import com.codingdojo.event.models.Event;
import com.codingdojo.event.models.User;
import com.codingdojo.event.repositories.CommentRepository;
import com.codingdojo.event.repositories.EventRepository;
import com.codingdojo.event.repositories.UserRepository;

@Service
public class AppService {
private final CommentRepository cmntRepo;
private final UserRepository userRepo;
private final EventRepository eventRepo;
public AppService(CommentRepository cmntRepo,  UserRepository userRepo,
		EventRepository eventRepo) {
	super();
	this.cmntRepo = cmntRepo;
	this.userRepo = userRepo;
	this.eventRepo = eventRepo;
} 
//user methods
public User registerUser(User user) {
    String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
    user.setPassword(hashed);
    return userRepo.save(user);
}

public User findByEmail(String email) {
    return userRepo.findByEmail(email);
}

// find user by id
public User findUserById(Long id) {
	    return userRepo.findById(id).orElse(null); 
	}  // return userRepository.findById(id).orElse(null);

// authenticate user
// login
public boolean authenticateUser(String email, String password) {
    // first find the user by email
    User user = userRepo.findByEmail(email);
    // if we can't find it by email, return false
    if(user == null) {
        return false;
    } else {
//if the passwords match, return true, else, return false
        if(BCrypt.checkpw(password, user.getPassword())) {
            return true;
        } else {
            return false;
        }
    }
}
//message
public Comment createMsg(Comment c) {
	return cmntRepo.save(c);
}
public Comment findMsg(Long id) {
	return cmntRepo.findById(id).orElse(null);
}
public List<Comment> getAllMsgs(){
	return cmntRepo.findAll();
}
public Comment updateMsg(Comment c) {
	return cmntRepo.save(c);// createMsg(c);
}
public void destroyMsg(Long id ) {
	 cmntRepo.deleteById(id);
}
//event 
public Event createEvnt(Event e) {
	return eventRepo.save(e);
}
public Event findEvnt(Long id) {
	return eventRepo.findById(id).orElse(null);
}
public List<Event> getAllEvnts(){
	return eventRepo.findAll();
}
public Event updateEvnt(Event e) {
	return eventRepo.save(e);
}
public void destroyEvnt(Long id) {
	eventRepo.deleteById(id);
}
public ArrayList<Event> EvntInState(String state){
	return (ArrayList<Event>)eventRepo.findByState(state);
}
public ArrayList<Event> EvntNotInState(String state){
	return (ArrayList<Event>)eventRepo.findByStateIsNot(state);
}
}
