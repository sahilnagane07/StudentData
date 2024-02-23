package com.example.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.student.model.Student;
import com.example.student.repository.StudentRepository;

@Service
public class StudentServiceImpl implements IStudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student createState(Student student) {
		studentRepository.save(student);
		return student;
	}

	@Override
	public List<Student> getAllStudents() {
	
		List<Student> students=studentRepository.findAll();
		return students;
	}

	@Override
	public Student updateStudent(Long id,Student student) {
	    // Retrieve the existing student from the repository using the provided id
	    Optional<Student> optionalStudent = studentRepository.findById(id);

	    if (optionalStudent.isPresent()) {
	        // If the student with the provided id exists, update its fields
	        Student existingStudent = optionalStudent.get();
	        existingStudent.setFirstName(student.getFirstName());
	        existingStudent.setLastName(student.getLastName());
	        existingStudent.setAge(student.getAge());
	        existingStudent.setEmail(student.getEmail());

	        // Save the changes to the repository
	        studentRepository.save(existingStudent);

	        // Return the updated student
	        return existingStudent;
	    } else {
	        // Handle the case where the student with the provided id is not found
	        return null;
	    }
	}


	@Override
	public List<Student> deleteStudentById(Long id)
	{
		Student student2=studentRepository.findById(id).get();
		studentRepository.delete(student2);
		List<Student> students=studentRepository.findAll();
		return students;
	}

}
