package com.control;

import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.to.BackupPlayer;
import com.to.Player;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateBackupMain {
	
	public static void main(String[] args) {
		try {
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(com.to.BackupPlayer.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());
		
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		BackupPlayer p3 = new BackupPlayer("MS Dhoni",99f, "CSK", "Domestic");
		BackupPlayer p2 = new BackupPlayer("Mitchell Marsh", 15f, "MI", "International");
		session.save(p2);
		session.save(p3);
		transaction.commit();
		session.close();
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
