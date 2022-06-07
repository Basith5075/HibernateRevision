package com.control;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.build.AllowSysOut;

import com.to.Player;

@SuppressWarnings("deprecation")
public class HQLDeleteMain {

	public static void main(String[] args) {
		Session session =null;
		Transaction transaction = null;
		try {
			Scanner scan = new Scanner(System.in);
			Configuration configuration = new Configuration().configure();
			configuration.addAnnotatedClass(com.to.Player.class);
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
			SessionFactory factory = configuration.buildSessionFactory(builder.build());
			
			session = factory.openSession();
			transaction = session.beginTransaction();
		     System.out.println("Simple Delete");

		        String deleteString = "delete from Player p where p.Id =12";
		        Query query = session.createQuery(deleteString);
		        int count = query.executeUpdate();

		        System.out.println(count + " Record(s) Updated.");
		        
		        System.out.println("Deleting with Query Parameters ");
		        System.out.println("Enter record ID which you want to delete");
		        int pid =Integer.parseInt(scan.next());
		        String deleteString2 = "delete from Player p where p.Id = :pid";
		        Query query2 = session.createQuery(deleteString2);
		        query2.setParameter("pid",pid);

		        int count2 = query2.executeUpdate();

		        System.out.println(count2 + " Record(s) Updated.");
		      
			}			
			
		 catch (Exception e) {
			
		}finally {
			transaction.commit();
			session.close();
			System.out.println("closed session");
		}

	}

}
