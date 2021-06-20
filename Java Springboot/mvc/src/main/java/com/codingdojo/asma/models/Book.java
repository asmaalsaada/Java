package com.codingdojo.asma.models;


import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
@Table(name="books")// table name in db
public class Book {
    @Id //primaryKey
    @GeneratedValue(strategy = GenerationType.IDENTITY) // sets this as an auto-incrementing value
    private Long id; // @Id,@Generated are id's annotations
    @NotNull // validation.. ,mustn't be null
    @Size(min = 5, max = 200)
    private String title;
    @NotNull
    @Size(min = 5, max = 200) //  validation that the column must be at least the specified range
    private String description;
    @NotNull
    @Size(min = 3, max = 40) 
    private String language;
    @NotNull
    @Min(100) // validation that the column must be at least the specified value
    private Integer numberOfPages;
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    public Book() {}
    
    public Book(Long id,String title,String description,String language,Integer numberOfPages) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.language = language;
		this.numberOfPages = numberOfPages;
	}

	public Book(String title, String desc, String lang, int pages) {
        this.title = title;
        this.description = desc;
        this.language = lang;
        this.numberOfPages = pages;
    } //making a constructor with the table's columns
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public Integer getNumberOfPages() {
		return numberOfPages;
	}
	public void setNumberOfPages(Integer numberOfPages) {
		this.numberOfPages = numberOfPages;
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
	
    @PrePersist  // runs the method right before the object is created
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate // runs a method when the object is modified

    protected void onUpdate(){
        this.updatedAt = new Date();
    }
}
