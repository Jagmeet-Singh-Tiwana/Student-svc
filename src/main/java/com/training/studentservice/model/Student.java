package com.training.studentservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
//import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long studId;
	private String name;
	private int age;
	
	private String grade;
	
	public long getStudId() {
		return studId;
	}
	public void setStudId(long studId) {
		this.studId = studId;
	}
	
	
	public Student() {
		super();
	}
	public Student(String name, int age, String grade) {
		super();
		
		this.name = name;
		this.age = age;
		this.grade = grade;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Object getStudName() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setStudName(Object studName) {
		// TODO Auto-generated method stub
		
	}
}



