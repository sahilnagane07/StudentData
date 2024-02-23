package com.example.student.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student.model.Student;
import com.example.student.service.IStudentService;

@RequestMapping("/api")
@RestController
public class StudentController {
	 
	@Autowired
	private IStudentService studentService;
	
	
	@PostMapping("/student/post")
	public ResponseEntity<Student> createBook(@RequestBody Student student)
	{
		
		Student student2=studentService.createState(student);
		
		if(student2!=null)
		{
			return new ResponseEntity("Student created Successfully", HttpStatus.CREATED);

		}
		
		return new ResponseEntity("State Object creation Error!",
				HttpStatus.BAD_REQUEST);
		
	}
	
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents(){
		List<Student> students= studentService.getAllStudents();
		if(students.isEmpty())
			return new ResponseEntity("Sorry! Student DB is empty!", HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);
	}
	
	
	@DeleteMapping("/student/{id}")
	public ResponseEntity<List<Student>> findStateById(@PathVariable("id")Long id){
		List<Student> students=studentService.deleteStudentById(id);
		
		if(students.isEmpty())
			return new ResponseEntity("Sorry! Student DB is empty!", HttpStatus.BAD_REQUEST);
		
		return new ResponseEntity<List<Student>>(students, HttpStatus.OK);

	}
	
	@PutMapping("/updatestudent/{id}")
	public ResponseEntity<Student> updateStudentById(@PathVariable("id")Long id,@RequestBody Student student)
	{
		
		Student student2=studentService.updateStudent(id,student);
		
		if(student2!=null)
		{
			return new ResponseEntity(student2, HttpStatus.OK);

		}
		
		return new ResponseEntity(student2, HttpStatus.OK);

		
	}
	
	
	

}
