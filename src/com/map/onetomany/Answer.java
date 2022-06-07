package com.map.onetomany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_answer")
public class Answer {

	@Id
	@Column(name="answer_id")
	private int aid;
	private String answer;
	@ManyToOne
	private Question quest;
	
	public Answer(int aid, String answer, Question quest) {
		super();
		this.aid = aid;
		this.answer = answer;
		this.quest = quest;
	}
	public Question getQuest() {
		return quest;
	}
	public void setQuest(Question quest) {
		this.quest = quest;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
