package com.codingdojo.event.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
 @Id
 @GeneratedValue(strategy=GenerationType.IDENTITY)
 
 private Long id;
 @NotBlank
 private String firstName;
 private String lastName;
 @Email(message="Email must be valid!")
 private String email;
 @Size(min=1,max=255,message="City must be between 1-255 character")
 private String city;
 private String state;
 @Size(min=1,max=255,message="Password must be betwen"
 		+ "")
 private String password;
 @Transient
 @Size(min=1,max=255)
 private String passwordConfirmation;
 @Column(updatable=false)
 private Date createdAt;
 private Date updatedAt;
// @ManyToOne(fetch=FetchType.LAZY)
// @JoinColumn(name="state_user")
// private State state_user;
 
 @ManyToMany(fetch = FetchType.LAZY)
 @JoinTable(
     name = "users_events", 
     joinColumns = @JoinColumn(name = "event_id"), 
     inverseJoinColumns = @JoinColumn(name = "user_id")
     )
 private List<Event> events; //
//@OneToMany// messages
 @OneToMany(mappedBy="user_text", fetch = FetchType.LAZY)
 private List<Comment> user;// who wrote the message
@OneToMany(mappedBy="host",fetch=FetchType.LAZY)
private List<Event> hosted_events;
 public User() {}
 
public User(String firstName, String lastName, @Email(message = "Email must be valid!") String email,
		@Size(min = 1, max = 255, message = "City must be between 1-255 character") String city, String state,
		String password, String passwordConfirmation, List<Event> events, List<Comment> user,
		List<Event> hosted_events) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.city = city;
	this.state = state;
	this.password = password;
	this.passwordConfirmation = passwordConfirmation;
	this.events = events;
	this.user = user;
	this.hosted_events = hosted_events;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getPasswordConfirmation() {
	return passwordConfirmation;
}
public void setPasswordConfirmation(String passwordConfirmation) {
	this.passwordConfirmation = passwordConfirmation;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

public Date getCreatedAt() {
	return createdAt;
}

public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
}

public Date getUpdatedAt() {
	return updatedAt;
}

public void setUpdatedAt(Date updatedAt) {
	this.updatedAt = updatedAt;
}

public List<Comment> getUser() {
	return user;
}

public void setUser(List<Comment> user) {
	this.user = user;
}

public List<Event> getEvents() {
	return events;
}
public void setEvents(List<Event> events) {
	this.events = events;
}

public List<Event> getHosted_events() {
	return hosted_events;
}


public void setHosted_events(List<Event> hosted_events) {
	this.hosted_events = hosted_events;
}


public Long getId() {
	return id;
}
 
}
