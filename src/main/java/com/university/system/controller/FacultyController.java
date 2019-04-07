package com.university.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.university.system.model.Faculty;
import com.university.system.model.Student;
import com.university.system.service.FacultyService;
import com.university.system.service.StudentService;

@CrossOrigin(origins="http://localhost:9955")
@RestController
public class FacultyController {

	@Autowired
	FacultyService facultyService;
	
	//@RequestMapping(value = "/getAllStudents", method = RequestMethod.GET, headers = "Accept=application/json")
	@RequestMapping(value="/getAllFaculties", method = RequestMethod.GET)
	public List<Faculty> getFaculties() {
		
		List<Faculty> listOfFaculties = facultyService.getAllFaculties();
		return listOfFaculties;
	}
	
	@RequestMapping(value = "/getFaculty/{id}", method = RequestMethod.GET)
	public Faculty getFacultyById(@PathVariable int id) {
		return facultyService.getFaculty(id);
	}

	@RequestMapping(value = "/addFaculty", method = RequestMethod.POST, headers = "Accept=application/json")
	public void addFaculty(@RequestBody Faculty faculty) {	
		facultyService.addFaculty(faculty);
		
	}

	@RequestMapping(value = "/updateFaculty/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public void updateFaculty(@RequestBody Faculty faculty,@PathVariable int id) {
		faculty.setFaculty_id(id);
		facultyService.updateFaculty(faculty);
	}

	@RequestMapping(value = "/deleteFaculty/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteFaculty(@PathVariable("id") int id) {
		facultyService.deleteFaculty(id);		
	}
}
