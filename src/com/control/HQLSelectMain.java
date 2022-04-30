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
public class HQLSelectMain {

	public static void main(String[] args) {
		Session session =null;
		try {
			Scanner scan = new Scanner(System.in);
			Configuration configuration = new Configuration().configure();
			configuration.addAnnotatedClass(com.to.Player.class);
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
			SessionFactory factory = configuration.buildSessionFactory(builder.build());
			
			session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			
//			String selectQuery = "SELECT p.playerName, p.playerTeam FROM Player p";
			String selectQuery = "SELECT p.playerName, p.playerTeam, p.Id FROM Player p WHERE p.id = :Id ORDER BY Id DESC";
//			String selectQuery = "SELECT p.playerName, p.playerTeam, p.Id FROM Player p GROUP by p.playerTeam";
			System.out.println("Please Enter Player ID:");
			int id = scan.nextInt();
			Query query = session.createQuery(selectQuery);
			query.setParameter("Id", id);
			List<Object[]> list = query.list();
			
//			Iterator itr = list.iterator();
//			System.out.println(itr);
//			System.out.println(itr.hasNext());
//			
			for(Object[] playing:list) {
				String name = (String)playing[0];
				String team = (String)playing[1];
				int playerId = (int)playing[2];
				System.out.println(team+" : "+name+" : "+playerId);
//				System.out.print(" :: "+play.getAge());
//				System.out.println(" :: "+play.getPlayerTeam());
//				System.out.println("--------------------------");
			}			
			
		} catch (Exception e) {
			
		}finally {
			session.close();
		}

	}

}
