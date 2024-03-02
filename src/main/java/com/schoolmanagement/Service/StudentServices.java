package com.schoolmanagement.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.repositories.StudentRepository;
import com.schoolmanagement.entities.StudentVO;

@Service
public class StudentServices {
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<StudentVO> getStudents()
	{
		return studentRepository.findAll();	
		
	}
	
	public StudentVO getstudentById(Long stuId) {
		
		StudentVO student=null;
		try
		{
			Optional<StudentVO> result=studentRepository.findById(stuId);
			student=result.get();
			
//			student=.orElseThrow(()->new ResourceNotFoundException("Student not found with id " +stuId));
		}catch(NoSuchElementException e)
		{
			
		}
		return student;
	}
	
	
//	public StudentVO getstudentByend(String fname) {
//		return studentRepository.findstudentwithend(fname);
//	}
	
	public StudentVO createStudent(StudentVO student)
	{
		StudentVO st=studentRepository.findByEmail(student.getEmail());
		if(st!=null)
		{
			return null;
		}
		student.setPassword(passwordEncoder.encode(student.getPassword()));
		return studentRepository.save(student);
	}
}
