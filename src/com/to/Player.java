package com.to;

import javax.annotation.processing.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
@Entity
@Table(name="tb_player")
public class Player {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	@Column(name="name",nullable = false)
	private String playerName;
	private float age;
	@Column(length = 75)
	private String playerTeam;
	@Column(length = 50)
	private String playerInternationalStatus;
	public Player() {
	}
	public Player(String playerName, float age, String playerTeam, String playerInternationalStatus) {
		super();
		this.playerName = playerName;
		this.age = age;
		this.playerTeam = playerTeam;
		this.playerInternationalStatus = playerInternationalStatus;
	}
	public Player(float age, String playerTeam, String playerInternationalStatus) {
		super();
		this.age = age;
		this.playerTeam = playerTeam;
		this.playerInternationalStatus = playerInternationalStatus;
	}
	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}
	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public float getAge() {
		return age;
	}

	public void setAge(float age) {
		this.age = age;
	}

	public String getPlayerTeam() {
		return playerTeam;
	}

	public void setPlayerTeam(String playerTeam) {
		this.playerTeam = playerTeam;
	}

	public String getPlayerInternationalStatus() {
		return playerInternationalStatus;
	}

	public void setPlayerInternationalStatus(String playerInternationalStatus) {
		this.playerInternationalStatus = playerInternationalStatus;
	}

	public Player(int id, String playerName, float age, String playerTeam, String playerInternationalStatus) {
		super();
		Id = id;
		this.playerName = playerName;
		this.age = age;
		this.playerTeam = playerTeam;
		this.playerInternationalStatus = playerInternationalStatus;
	}

	@Override
	public String toString() {
		return "Player [Id=" + Id + ", playerName=" + playerName + ", age=" + age + ", playerTeam=" + playerTeam
				+ ", playerInternationalStatus=" + playerInternationalStatus + "]";
	}
	
	
	
}
