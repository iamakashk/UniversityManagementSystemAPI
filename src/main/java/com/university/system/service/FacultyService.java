package com.university.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.university.system.dao.FacultyDAO;
import com.university.system.model.Faculty;

@Service("facultyService")
public class FacultyService {


	@Autowired
	FacultyDAO facultyDao;
	
	@Transactional
	public List<Faculty> getAllFaculties() {
		return facultyDao.getAllFaculties();
	}

	@Transactional
	public Faculty getFaculty(int id) {
		return facultyDao.getFaculty(id);
	}

	@Transactional
	public void addFaculty(Faculty faculty) {
		facultyDao.addFaculty(faculty);
	}

	@Transactional
	public void updateFaculty(Faculty faculty) {
		facultyDao.updateFaculty(faculty);

	}

	@Transactional
	public void deleteFaculty(int id) {
		facultyDao.deleteFaculty(id);
	}
}
