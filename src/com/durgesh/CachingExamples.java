package com.durgesh;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cache.ehcache.internal.EhcacheRegionFactory;
import org.hibernate.cfg.Configuration;

public class CachingExamples {
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session1 = factory.openSession();
		
		Student stud = (Student)session1.get(Student.class, 1);
		
		System.out.println("Session1 "+stud);
		session1.close();

		Session session2 = factory.openSession();

		Student stud1 = (Student)session2.get(Student.class, 1);
		
		System.out.println("Session1 "+stud1);	
		
		factory.close();
	}
}
