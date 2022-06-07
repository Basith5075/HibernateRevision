package com.durgesh;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {
	 public static void main(String[] args) throws IOException{
		
		 Configuration cfg = new Configuration();
		 cfg.configure("hibernate.cfg.xml");
		 SessionFactory factory = cfg.buildSessionFactory();
		 
		 // Creating Student 
		 Student st = new Student();
		 st.setId(1);
		 st.setName("Abdul Basith");
		 st.setCity("Hyd");
		 System.out.println(st);	
		 
		 // Creating Address
		 Address ad = new Address();
		 ad.setCity("Hyderabad");
		 ad.setOpen(true);
		 ad.setAddedDate(new Date());
		 ad.setX(1532.52);
		 
		 //Saving Image
		 FileInputStream fis = new FileInputStream("src/Photo.jpeg");
		 byte arr[] = new byte[fis.available()];
		 fis.read(arr);
		 ad.setImage(arr);
		 ad.setStreet("H.NO : SRT 44");
		 
		 //Saving data into DB
		 Session session = factory.openSession();
		 Transaction transaction =  session.beginTransaction();
		 session.save(st);
		 session.save(ad);
		 transaction.commit();		 
		 session.close();
		 
	}
}
