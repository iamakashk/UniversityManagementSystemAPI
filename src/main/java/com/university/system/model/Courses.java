package com.university.system.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Table(name="UNIVERSITY_COURSES")
@Proxy(lazy = false)

public class Courses {

	@Id
	@Column(name="UC_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int course_id;
	
	@Column(name="UC_NAME")
	private String course_name;
	
		
	@OneToMany(mappedBy="courses", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Set<Student> Student;
	
	@OneToMany(mappedBy="courses", cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private Set<Faculty> faculty;
	public Set<Faculty> getFaculty() {
		return faculty;
	}
	public void setFaculty(Set<Faculty> faculty) {
		this.faculty = faculty;
	}
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public Set<Student> getStudent() {
		return Student;
	}
	public void setStudent(Set<Student> student) {
		Student = student;
	}
	

}
