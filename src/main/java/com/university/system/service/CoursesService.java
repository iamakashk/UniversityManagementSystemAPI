package com.university.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.university.system.dao.CoursesDAO;
import com.university.system.dao.FacultyDAO;
import com.university.system.model.Courses;
import com.university.system.model.Faculty;

@Service("courseService")
public class CoursesService {



	@Autowired
	CoursesDAO courseDao;
	
	@Transactional
	public List<Courses> getAllCourses() {
		return courseDao.getAllCourses();
	}

	@Transactional
	public Courses getCourse(int id) {
		return courseDao.getCourse(id);
	}

	@Transactional
	public void addCourse(Courses courses) {
		courseDao.addCourse(courses);
	}

	@Transactional
	public void updateCourse(Courses courses) {
		courseDao.updateCourse(courses);

	}

	@Transactional
	public void deleteCourse(int id) {
		courseDao.deleteCourse(id);
	}
}

