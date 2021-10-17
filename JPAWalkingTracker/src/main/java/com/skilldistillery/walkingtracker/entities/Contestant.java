package com.skilldistillery.walkingtracker.entities;

import java.sql.Time;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contestant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private char gender;
	
	private int age;
	
	@Column(name="contestant_image")
	private String contestantImage;
	
	@Column(name="representing_city")
	private String RepresentingCity;
	
	@Column(name="representing_state")
	private String RepresentingState;
	
	@Column(name="event_name")
	private String eventName;
	
	@Column(name="event_date")
	private String eventDate;
	
	@Column(name="finish_time")
	private String finishTime;
	
	private int place;
	
	public Contestant() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getContestantImage() {
		return contestantImage;
	}

	public void setContestantImage(String contestantImage) {
		this.contestantImage = contestantImage;
	}

	public String getRepresentingCity() {
		return RepresentingCity;
	}

	public void setRepresentingCity(String representingCity) {
		RepresentingCity = representingCity;
	}

	public String getRepresentingState() {
		return RepresentingState;
	}

	public void setRepresentingState(String representingState) {
		RepresentingState = representingState;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public String getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public int getPlace() {
		return place;
	}

	public void setPlace(int place) {
		this.place = place;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contestant other = (Contestant) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Contestant [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + ", contestantImage="
				+ contestantImage + ", RepresentingCity=" + RepresentingCity + ", RepresentingState="
				+ RepresentingState + ", eventDate=" + eventDate + ", finishTime=" + finishTime + ", eventName="
				+ eventName + ", place=" + place + "]";
	}
}
