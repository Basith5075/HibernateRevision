package com.map.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class OnetoOneMain {
	
	
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Question quest = new Question();
		quest.setQid(1212);
		quest.setQuestion("What is Java ?");
		
		Question quest1 = new Question();
		quest1.setQid(1213);
		quest1.setQuestion("What is API?");
		
		Answer ans = new Answer();
		ans.setAid(152);
		ans.setAnswer("Java is a Programming language used to develop web apps");
		
		Answer ans1 = new Answer();
		ans1.setAid(153);
		ans1.setAnswer("API is a Application Programming Interface");
		
		quest.setAnswer(ans);
		quest1.setAnswer(ans1);
		ans.setQuest(quest);
		ans1.setQuest(quest1);	
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(quest);
		session.save(quest1);
		session.save(ans);
		session.save(ans1);
		
		
		Question ques1 = session.get(Question.class, 1212);
		Question ques2 = session.get(Question.class, 1213);
		
		System.out.println(ques1.getQuestion());
		System.out.println(ques1.getAnswer().getAnswer());
		System.out.println(ques2.getQuestion());
		System.out.println(ques2.getAnswer().getAnswer());
		
		Answer aws = session.get(Answer.class, 153);
		System.out.println(aws.getAid());
		System.out.println(aws.getAnswer());
		System.out.println(aws.getQuest().getQuestion());
		
		tx.commit();
		
		
		session.close();
	}
}
