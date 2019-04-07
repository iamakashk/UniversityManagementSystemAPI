package com.university.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.university.system.model.Student;
import com.university.system.service.StudentService;

@CrossOrigin(origins="http://localhost:9955")
@RestController
public class StudentController {

	@Autowired
	StudentService studentService;
	
	//@RequestMapping(value = "/getAllStudents", method = RequestMethod.GET, headers = "Accept=application/json")
	@RequestMapping(value="/getallstudents", method = RequestMethod.GET)
	public List<Student> getCountries() {
		
		List<Student> listOfCountries = studentService.getAllStudents();
		return listOfCountries;
	}
	
	@RequestMapping(value = "/getStudent/{id}", method = RequestMethod.GET)
	public Student getStudentById(@PathVariable int id) {
		return studentService.getStudent(id);
	}

	@RequestMapping(value = "/addStudent", method = RequestMethod.POST, headers = "Accept=application/json")
	public void addCountry(@RequestBody Student student) {	
		System.out.println(student.getCourses());
		System.out.println(student.getStudent_first_name());
		System.out.print(student.getStudent_last_name());
		studentService.addStudent(student);
		
	}

	@RequestMapping(value = "/updateStudent/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public void updateCountry(@RequestBody Student student,@PathVariable int id) {
		student.setStudent_id(id);
		studentService.updateStudent(student);
	}

	@RequestMapping(value = "/deleteStudent/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteCountry(@PathVariable("id") int id) {
		studentService.deleteStudent(id);		
	}
}
