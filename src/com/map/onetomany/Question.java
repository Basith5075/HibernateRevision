package com.map.onetomany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_question")
public class Question {
	
	@Id
	@Column(name="question_id")
	private int qid;
	private String question;
	
	@OneToMany(mappedBy = "quest", fetch = FetchType.EAGER)
	private List<Answer> answer;

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}


	public Question(int qid, String question, List<Answer> answer) {
		super();
		this.qid = qid;
		this.question = question;
		this.answer = answer;
	}

	public List<Answer> getAnswer() {
		return answer;
	}

	public void setAnswer(List<Answer> answer) {
		this.answer = answer;
	}

	public Question() {
		super();
	}
	
	
	
	
}
