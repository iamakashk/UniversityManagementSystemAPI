package com.university.system.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "UNIVERSITY_STUDENTS")

//got error related to proxy so have to add this to remove databinding error
@Proxy(lazy = false)
public class Student {

	@Id
	@Column(name = "US_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int student_id;

	@Column(name = "US_FIRST_NAME")
	private String student_first_name;

	@Column(name = "US_LAST_NAME")
	private String student_last_name;

	@Column(name = "UC_ID")
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

	public Student() {

	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public String getStudent_first_name() {
		return student_first_name;
	}

	public void setStudent_first_name(String student_first_name) {
		this.student_first_name = student_first_name;
	}

	public String getStudent_last_name() {
		return student_last_name;
	}

	public void setStudent_last_name(String student_last_name) {
		this.student_last_name = student_last_name;
	}

}
