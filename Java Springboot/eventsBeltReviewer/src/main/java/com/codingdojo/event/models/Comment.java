package com.codingdojo.event.models;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="comments")
public class Comment {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
@NotNull
@Size(min=8,max=255,message="message should be at least 8 characters")
private String text;
 //user
@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="user_message")//
private User user_text; 
// event
@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="event_message")//
private Event event_message;

public Comment() {}

public Comment(@NotNull @Size(min = 8, max = 255, message = "message should be at least 8 characters") String text,
		User user_text, Event event_message) {
	super();
	this.text = text;
	this.user_text = user_text;
	this.event_message = event_message;
}

public String getText() {
	return text;
}

public void setText(String text) {
	this.text = text;
}

public User getUser_text() {
	return user_text;
}

public void setUser_text(User user_text) {
	this.user_text = user_text;
}

public Event getEvent_text() {
	return event_message;
}

public void setEvent_text(Event event_text) {
	this.event_message = event_text;
}

public Long getId() {
	return id;
} 


}
