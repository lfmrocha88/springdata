package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Books {

	@Id
	@Column(name="isbn")
	String isbn;

	String title;
	
	@ManyToOne
    @JoinColumn(name="author_id")
    private Authors author;
	
	String yearPub;
	
	String description;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Authors getAuthor() {
		return author;
	}

	public void setAuthor(Authors author) {
		this.author = author;
	}

	public String getYearPub() {
		return yearPub;
	}

	public void setYearPub(String yearPub) {
		this.yearPub = yearPub;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
