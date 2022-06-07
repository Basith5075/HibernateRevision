package com.durgesh;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbedableMain {

	public static void main(String[] args) {
		 Configuration cfg = new Configuration();
		 cfg.configure("hibernate.cfg.xml");
		 SessionFactory factory = cfg.buildSessionFactory();
		 Student1 stud = new Student1();
		 stud.setId(1);
		 stud.setCity("Warangal");
		 stud.setName("Jahangir Pasha");
		 
		 Certificate cert = new Certificate();
		 cert.setCourse("Android");
		 cert.setDurationInDays(60);
		 
		 stud.setCert(cert);
		 
		 
		 Session session = factory.openSession();
		 Transaction tx = session.beginTransaction();
		 
		 session.save(stud);
		 
		 tx.commit();
		 session.close();
	}
}
