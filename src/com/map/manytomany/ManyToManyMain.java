package com.map.manytomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ManyToManyMain {

	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
//		Emp e1 = new Emp();
//		e1.setEid(1);
//		e1.setName("Abdul Basith");
//		
//		Emp e2 = new Emp();
//		e2.setEid(2);
//		e2.setName("Bairstow");
//		
//		Emp e3 = new Emp();
//		e3.setEid(3);
//		e3.setName("Peterson");
//		
//		
//		Project p1 = new Project();
//		p1.setPid(1254);
//		p1.setName("TechBlog");
//		
//		Project p2 = new Project();
//		p2.setPid(1255);
//		p2.setName("MindSpace app");
//		
//		Project p3 = new Project();
//		p3.setPid(1256);
//		p3.setName("Mimpy");
//		
//		List<Project> e1e2List = new ArrayList<Project>();
//		List<Project> e3List = new ArrayList<Project>();
//		
//		e1e2List.add(p1);
//		e1e2List.add(p2);
//		
//
//		e3List.add(p3);
//		e3List.add(p1);
//		
//		e1.setProjList(e1e2List);
//		e2.setProjList(e1e2List);
//		e3.setProjList(e3List);
//		
//		List<Emp> p1p2List = new ArrayList<Emp>();
//		List<Emp> p3List = new ArrayList<Emp>();
//		
//		
//		p1p2List.add(e1);
//		p1p2List.add(e2);
//		
//		p3List.add(e3);
//		
//		p1.setEmpList(p1p2List);
//		p2.setEmpList(p1p2List);
//		p1.setEmpList(p3List);
//		p3.setEmpList(p3List);
		
		Session session = factory.openSession();
//		Transaction tx = session.beginTransaction();
//		
//		session.save(e1);
//		session.save(e2);
//		session.save(e3);
//		session.save(p1);
//		session.save(p2);
//		session.save(p3);
//		tx.commit();
		
		Emp name = (Emp)session.get(Emp.class, 2);
		System.out.println(name.getName());
		
		List<Project> nameProj = name.getProjList();
		
		for(Project a:nameProj) {
			System.out.println(a.getName());
		}
		
		session.close();
		
		
	}

}
