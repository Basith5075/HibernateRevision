package com.map.onetomany;

import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HQLJoinMain {
	public static void main(String[] args) {
		
		Configuration configuration = new Configuration().configure();
		SessionFactory factory = configuration.buildSessionFactory();
		
		Session session = factory.openSession();
		
		String query = "select q.qid, q.question, a.answer from Question as q INNER JOIN q.answer as a";
		
		Query q = session.createQuery(query);
		
		List<Object[]> list =  q.list();
		
		for(Object[] obj : list) {
			System.out.print(obj[0]+" : ");
			System.out.print(obj[1]+" : ");
			System.out.println(obj[2]);
		}
		
		session.close();
	}
}
