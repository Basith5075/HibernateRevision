package com.map.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Emp {
	
	@Id
	private int eid;
	private String name;
	@ManyToMany
	@JoinTable(
				name = "emp_learn",
				joinColumns = {@JoinColumn(name = "eid")},
				inverseJoinColumns ={@JoinColumn(name = "pid")}
			)
	private List<Project> projList;
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Project> getProjList() {
		return projList;
	}
	public void setProjList(List<Project> projList) {
		this.projList = projList;
	}
	public Emp(int eid, String name, List<Project> projList) {
		super();
		this.eid = eid;
		this.name = name;
		this.projList = projList;
	}
	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
