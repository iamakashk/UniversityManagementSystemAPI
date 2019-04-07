package com.university.system.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.university.system.model.Student;

@Repository
public class StudentsDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}

	public List<Student> getAllStudents() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Student> studentList = session.createQuery("from Student").list();
		return studentList;
	}

	public Student getStudents(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Student student = (Student) session.load(Student.class, new Integer(id));
		return student;
	}

	public Student addStudents(Student student) {
		Session session = this.sessionFactory.getCurrentSession();
		session.merge(student);
		return student;
	}

	public void updateStudents(Student student) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(student);
	}

	public void deleteStudents(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Student p = (Student) session.load(Student.class, new Integer(id));
		if (null != p) {
			session.delete(p);
		}
	}
}
