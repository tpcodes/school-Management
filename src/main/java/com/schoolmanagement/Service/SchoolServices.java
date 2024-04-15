package com.schoolmanagement.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.repositories.SchoolRepository;
import com.schoolmanagement.entities.SchoolVO;
import com.schoolmanagement.entities.StudentVO;

import jakarta.persistence.EntityNotFoundException;

@Service
public class SchoolServices {

	
	@Autowired
	private SchoolRepository schoolRepository;

	public List<SchoolVO> getSchools()
	{
		return schoolRepository.findAll();	
		
	}
	
	public SchoolVO getschoolById(Long schId) {
//		return schoolRepository.findById(schId).orElseThrow(()->new EntityNotFoundException("School not found with id " +schId));
		
		
		SchoolVO school=null;
		try
		{
			Optional<SchoolVO> result=schoolRepository.findById(schId);
			school=result.get();
			
//			student=.orElseThrow(()->new ResourceNotFoundException("Student not found with id " +stuId));
		}catch(NoSuchElementException e)
		{
			
		}
		return school;
	}
	
	
//	public StudentVO getstudentByend(String fname) {
//		return studentRepository.findstudentwithend(fname);
//	}
	
	public SchoolVO createSchool(SchoolVO school)
	{
		SchoolVO sch=schoolRepository.findByEmail(school.getEmail());
		if(sch!=null)
		{
			return null;
		}
		return schoolRepository.save(school);
	}
}
