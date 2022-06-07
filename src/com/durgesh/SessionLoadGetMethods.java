package com.durgesh;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionLoadGetMethods {

	public static void main(String[] args) {
		 Configuration cfg = new Configuration();
		 cfg.configure("hibernate.cfg.xml");
		 SessionFactory factory = cfg.buildSessionFactory();
		 Session session = factory.openSession();
		 
		 // Using get method of session object
		// 1. get method returns "null" if the requested object/row is not present in the table.
		// 2. get method fires the select query even if the requested object is not consumed/used in the program
		 Student stud = (Student) session.get(Student.class, 30);
		 System.out.println(stud);
		 
		// Using load method of session object
		// 1.  Load method returns "org.hibernate.ObjectNotFoundException" exception if the requested object/row is not present in the table.
		// 2. load method does not fires the select query if the requested object is not consumed/used in the program, it fires and loads the object/row only if the row data is consumed or used. Hence improves performance
		 try {
		 Student stud1 = (Student) session.load(Student.class, 20);
		 System.out.println(stud1);
		 }catch (ObjectNotFoundException e) {
			 System.out.println("Requested records are not available ..!!");
		}
	}
	
}
