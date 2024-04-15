package com.schoolmanagement.Service;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repositories.SubjectRepository;
import com.schoolmanagement.entities.SubjectVO;

@Service
public class SubjectServices {

	@Autowired
	private SubjectRepository subjectRepository;
	
	public List<SubjectVO> getSubjects()
	{
		return subjectRepository.findAll();	
		
	}
	public SubjectVO getsubById(Long subId) {
////		return schoolRepository.findById(schId).orElseThrow(()->new EntityNotFoundException("School not found with id " +schId));
		
		
		SubjectVO sub=null;
		try
		{
			Optional<SubjectVO> result=subjectRepository.findById(subId);
			sub=result.get();
			
//			student=.orElseThrow(()->new ResourceNotFoundException("Student not found with id " +stuId));
		}catch(NoSuchElementException e)
		{
			
		}
		return sub;
	}
	
	public SubjectVO createSubject(SubjectVO sub)
	{
		sub.setCrtDate(new Date());
		SubjectVO sub1=subjectRepository.findBySubCode(sub.getSubCode());
		if(sub1!=null)
		{
			return null;
		}
		return subjectRepository.save(sub);
	}
}
