package com.university.system.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="UNIVERSITY_FACULTY")
@Proxy(lazy = false)

public class Faculty {
	
	@Id
	@Column(name="UF_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int faculty_id;
	
	@Column(name="UF_FIRST_NAME")
	private String faculty_first_name;
	
	@Column(name="UF_LAST_NAME")
	private String faculty_last_name;
	
	private Long uc_id;

	public Long getUc_id() {
		return uc_id;
	}

	public void setUc_id(Long uc_id) {
		this.uc_id = uc_id;
	}

	@JsonIgnore
	@ManyToOne(optional = false)
	@JoinColumn(name = "UC_ID", insertable = false, updatable = false)
	private Courses courses;

	public Courses getCourses() {
		return courses;
	}

	public void setCourses(Courses courses) {
		this.courses = courses;
	}
	
	public int getFaculty_id() {
		return faculty_id;
	}
	public void setFaculty_id(int faculty_id) {
		this.faculty_id = faculty_id;
	}
	public String getFaculty_first_name() {
		return faculty_first_name;
	}
	public void setFaculty_first_name(String faculty_first_name) {
		this.faculty_first_name = faculty_first_name;
	}
	public String getFaculty_last_name() {
		return faculty_last_name;
	}
	public void setFaculty_last_name(String faculty_last_name) {
		this.faculty_last_name = faculty_last_name;
	}

}
