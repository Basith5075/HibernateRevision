package com.map.manytomany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {
	@Id
	private int pid;
	private String name;
	
	@ManyToMany(mappedBy = "projList")
	private List<Emp> empList;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Emp> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Emp> empList) {
		this.empList = empList;
	}

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(int pid, String name, List<Emp> empList) {
		super();
		this.pid = pid;
		this.name = name;
		this.empList = empList;
	}
}
