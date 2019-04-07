package com.university.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.university.system.model.Courses;
import com.university.system.model.Faculty;
import com.university.system.service.CoursesService;
import com.university.system.service.FacultyService;

@CrossOrigin(origins="http://localhost:9955")
@RestController
public class CoursesController {


	@Autowired
	CoursesService coursesService;
	
	//@RequestMapping(value = "/getAllStudents", method = RequestMethod.GET, headers = "Accept=application/json")
	@RequestMapping(value="/getAllCourses", method = RequestMethod.GET)
	public List<Courses> getCourses() {
		
		List<Courses> listOfCourses = coursesService.getAllCourses();
		return listOfCourses;
	}
	
	@RequestMapping(value = "/getCourse/{id}", method = RequestMethod.GET)
	public Courses getCourseById(@PathVariable int id) {
		return coursesService.getCourse(id);
	}

	@RequestMapping(value = "/addCourse", method = RequestMethod.POST, headers = "Accept=application/json")
	public void addCourse(@RequestBody Courses courses ) {	
		coursesService.addCourse(courses);
		
	}

	@RequestMapping(value = "/updateCourse/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public void updateCourse(@RequestBody Courses courses,@PathVariable int id) {
		//faculty.set_id(id);
		courses.setCourse_id(id);
		coursesService.updateCourse(courses);
	}

	@RequestMapping(value = "/deleteCourse/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteCourse(@PathVariable("id") int id) {
		coursesService.deleteCourse(id);		
	}

}
