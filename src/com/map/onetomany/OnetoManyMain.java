package com.map.onetomany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OnetoManyMain {
	
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
//		Question q1 = new Question();
//		q1.setQid(125);
//		q1.setQuestion("What is Java ?");
//		
//		Answer a1 = new Answer();
//		a1.setAid(12);
//		a1.setAnswer("Java is a famous modern programming language");
//		a1.setQuest(q1);
//		
//		Answer a2 = new Answer();
//		a2.setAid(13);
//		a2.setAnswer("Web development can be done using Java");
//		a2.setQuest(q1);
//		
//		Answer a3 = new Answer();
//		a3.setAid(14);
//		a3.setAnswer("Java is one of the most famous languages in the world");
//		a3.setQuest(q1);
//		
//		List<Answer> answerList = new ArrayList<Answer>();
//		answerList.add(a1);
//		answerList.add(a2);
//		answerList.add(a3);
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
//		session.save(q1);
//		session.save(a1);
//		session.save(a2);
//		session.save(a3);
		tx.commit();
		
		Question quest = (Question)session.get(Question.class, 125);
		System.out.println(quest.getQid());
		System.out.println(quest.getQuestion());
		List<Answer> listAnswer = quest.getAnswer();
		
		for(Answer a: listAnswer) {
			System.out.println(a.getAid()+" : "+a.getAnswer()+" : "+a.getQuest().getQid());
		}
		
		session.close();
	}
}
