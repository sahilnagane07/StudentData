package com.example.student.service;


import java.util.List;

import com.example.student.model.Student;


public interface IStudentService {
	
	public Student createState(Student student);
	public List<Student> getAllStudents();
	public Student updateStudent(Long id,Student student);
	public List<Student> deleteStudentById(Long id);



}
