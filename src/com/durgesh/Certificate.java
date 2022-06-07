package com.durgesh;

import javax.persistence.Embeddable;

@Embeddable
public class Certificate {
	
	private String course;
	private int durationInDays;
	
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public int getDurationInDays() {
		return durationInDays;
	}
	public void setDurationInDays(int durationInDays) {
		this.durationInDays = durationInDays;
	}
	public Certificate(String course, int durationInDays) {
		super();
		this.course = course;
		this.durationInDays = durationInDays;
	}
	public Certificate() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
