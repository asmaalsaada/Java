//package com.codingdojo.event.models;
//
//import java.util.Date;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//@Entity
//@Table(name="users_events")
//public class Attend {
//	 @Id
//	    @GeneratedValue(strategy = GenerationType.IDENTITY)
//	    private Long id;
//	    @Column(updatable=false)
//	    private Date createdAt;
//	    private Date updatedAt;
//	    @ManyToOne(fetch = FetchType.LAZY)
//	    @JoinColumn(name="host_id")
//	    private User user;
//	    
//	    @ManyToOne(fetch = FetchType.LAZY)
//	    @JoinColumn(name="event_id")
//	    private Event event;
//	    
//	    public Attend() {}
//
//		public Attend(User user, Event event) {
//			super();
//			this.user = user;
//			this.event = event;
//		}
//
//		public User getUser() {
//			return user;
//		}
//
//		public void setUser(User user) {
//			this.user = user;
//		}
//
//		public Event getEvent() {
//			return event;
//		}
//
//		public void setEvent(Event event) {
//			this.event = event;
//		}
//
//		public Long getId() {
//			return id;
//		}
//	    
//}
