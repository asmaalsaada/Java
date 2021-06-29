package com.codingdojo.event.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="events")
public class Event {
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 private Long id;
	 @Size(min=2,max=255,message="name must be at least 2 characters long")
	 private String name;
	 @NotNull
	 @Future(message="Time must be in the future")
	 @DateTimeFormat(pattern="yyyy-MM-dd")
	 private LocalDate date;
	 @NotNull
	 @Size(max=2)
	 private String state;
	 @NotNull
	 private String city;//or location
	 
	 @ManyToMany(fetch = FetchType.LAZY)
	 @JoinTable(
	     name = "users_events", 
	     joinColumns = @JoinColumn(name = "user_id"), 
	     inverseJoinColumns = @JoinColumn(name = "event_id")
	 )
	 private List<User> users; //event attendees (?)
	 @OneToMany(mappedBy="event_message",fetch=FetchType.LAZY)
	 private List<Comment> comments;//event messages
	 @ManyToOne(fetch=FetchType.LAZY)
	 @JoinColumn(name="host_id")
	  private User host;
	public Event() {}

	public Event(@Size(min = 2, max = 255, message = "name must be at least 2 characters long") String name,
			@NotNull @Future(message = "Time must be in the future") LocalDate date,
			@NotNull @Size(max = 2) String state, @NotNull String city, List<User> users, List<Comment> comments,
			User host) {
		super();
		this.name = name;
		this.date = date;
		this.state = state;
		this.city = city;
		this.users = users;
		this.comments = comments;
		this.host = host;
	}






	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Comment> getComments() {
		return comments;
	}


	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}


	public User getHost() {
		return host;
	}

	public void setHost(User host) {
		this.host = host;
	}

	public Long getId() {
		return id;
	} 
	
}
