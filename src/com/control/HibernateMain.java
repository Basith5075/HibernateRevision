package com.control;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.to.Player;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateMain {
	
	public static void main(String[] args) {
		try {
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(com.to.Player.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Player p3 = new Player("VRK",44.25f, "KKR", "Domestic");
		Player p2 = new Player("Arif Khan1", 152.25f, "LSG", "Domestic");
//		Player p = session.get(Player.class, 13);
//		System.out.println(p);
//		p.setAge(29);
//		session.delete(p);
//		System.out.println("Deleted record successfully!!");
		session.save(p2);
		session.save(p3);
		transaction.commit();
		session.close();
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
