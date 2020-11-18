package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Authors {

	 @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name="author_id")
	  private Integer id;
	 
	 @Column(name="name_last")
	 private String lastName;
	 
	 @Column(name="name_first")
	 private String firstName;
	 
	 @Column(name="country")
	 private String country;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	 
	 
	
}
