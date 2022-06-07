package com.durgesh;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class PaginationMain {

	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory factory = configuration.buildSessionFactory();
		
		Session session = factory.openSession();
		
		String query = "from Student";
		
		Query q = session.createQuery(query);

		q.setFirstResult(0);
		q.setMaxResults(2);
		
		List list = q.list();
		for(Object s: list) {
			Student st = (Student) s;
			System.out.println(st.getId()+" : "+st.getName()+" : "+st.getCity());
			
		}
		
		session.close();

	}

}
