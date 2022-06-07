package com.durgesh;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student1 {
	
	@Id
	private int id;
	private String name;
	private String city;
	private Certificate cert;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public Certificate getCert() {
		return cert;
	}
	public void setCert(Certificate cert) {
		this.cert = cert;
	}
	public Student1(int id, String name, String city, Certificate cert) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.cert = cert;
	}
	public Student1() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
