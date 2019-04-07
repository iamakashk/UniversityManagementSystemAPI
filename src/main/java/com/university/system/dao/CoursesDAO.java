package com.university.system.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.university.system.model.Courses;
import com.university.system.model.Faculty;

@Repository
public class CoursesDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public List<Courses> getAllCourses() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Courses> coursesList = session.createQuery("from Courses").list();
		return coursesList;
	}

	public Courses getCourse(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Courses courses = (Courses) session.load(Faculty.class, new Integer(id));
		return courses;
	}

	public Courses addCourse(Courses courses) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(courses);
		return courses;
	}

	public void updateCourse(Courses courses) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(courses);
	}

	public void deleteCourse(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Courses p = (Courses) session.load(Faculty.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	}
}