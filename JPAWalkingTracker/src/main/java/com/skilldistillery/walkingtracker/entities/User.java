package com.skilldistillery.walkingtracker.entities;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	
	private char gender;
	
	private int age;
	
	@Column(name="user_image")
	private String userImage;
	
	private String city;
	
	private String state;
	
	@Column(name="walking_date")
	private Date walkingDate;
	
	@Column(name="minute_duration")
	private int minuteDuration;

	public User() {
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

	public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getWalkingDate() {
		return walkingDate;
	}

	public void setWalkingDate(Date walkingDate) {
		this.walkingDate = walkingDate;
	}

	public int getMinuteDuration() {
		return minuteDuration;
	}

	public void setMinuteDuration(int minuteDuration) {
		this.minuteDuration = minuteDuration;
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
		User other = (User) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", gender=" + gender + ", age=" + age + ", userImage=" + userImage
				+ ", city=" + city + ", state=" + state + ", walkingDate=" + walkingDate + ", minuteDuration="
				+ minuteDuration + "]";
	}
}
