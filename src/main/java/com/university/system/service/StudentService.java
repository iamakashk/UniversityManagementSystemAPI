package com.university.system.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.university.system.dao.StudentsDAO;
import com.university.system.model.Student;

@Service("studentService")
public class StudentService {

	@Autowired
	StudentsDAO studentsDao;
	
	@Transactional
	public List<Student> getAllStudents() {
		return studentsDao.getAllStudents();
	}

	@Transactional
	public Student getStudent(int id) {
		return studentsDao.getStudents(id);
	}

	@Transactional
	public void addStudent(Student student) {
		studentsDao.addStudents(student);
	}

	@Transactional
	public void updateStudent(Student student) {
		studentsDao.updateStudents(student);

	}

	@Transactional
	public void deleteStudent(int id) {
		studentsDao.deleteStudents(id);
	}
}
