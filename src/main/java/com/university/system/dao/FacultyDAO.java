package com.university.system.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.university.system.model.Faculty;
import com.university.system.model.Student;

@Repository
public class FacultyDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public List<Faculty> getAllFaculties() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Faculty> facultyList = session.createQuery("from Faculty").list();
		return facultyList;
	}

	public Faculty getFaculty(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Faculty faculty = (Faculty) session.load(Faculty.class, new Integer(id));
		return faculty;
	}

	public Faculty addFaculty(Faculty faculty) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(faculty);
		return faculty;
	}

	public void updateFaculty(Faculty faculty) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(faculty);
	}

	public void deleteFaculty(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Faculty p = (Faculty) session.load(Faculty.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	}
}
