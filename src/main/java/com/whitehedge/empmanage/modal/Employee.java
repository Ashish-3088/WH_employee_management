package com.whitehedge.empmanage.modal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Employee {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private String id;

	@NotEmpty(message = "Name is required")
	private String name;

	@NotEmpty(message = "Please provide a city")
	private String city;

	private int age;

	@JsonIgnore
	@Column(name = "isvisible")
	private boolean isvisible = true;

	public Employee() {
	}

	public Employee(String id, String name, String city, int age, boolean isvisible) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.age = age;
		this.isvisible = isvisible;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isIsvisible() {
		return isvisible;
	}

	public void setIsvisible(boolean isvisible) {
		this.isvisible = isvisible;
	}

}
