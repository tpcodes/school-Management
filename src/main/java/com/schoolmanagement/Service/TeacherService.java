package com.schoolmanagement.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repositories.TeacherRepository;
import com.schoolmanagement.entities.TeacherVO;

@Service
public class TeacherService {

	@Autowired
	private TeacherRepository teacherRepository;
	
	public List<TeacherVO> getTeachers()
	{
		return teacherRepository.findAll();	
		
	}
	
	public TeacherVO getTeacherById(Long tchrId) {
		
		TeacherVO tchr=null;
		try
		{
			Optional<TeacherVO> result=teacherRepository.findById(tchrId);
			tchr=result.get();
			
		}catch(NoSuchElementException e)
		{
			
		}
		return tchr;
	}
	
	
	public TeacherVO createTeacher(TeacherVO taecherVO)
	{

		TeacherVO tchr=teacherRepository.findByEmail(taecherVO.getEmail());
		if(tchr!=null)
		{
			return null;
		}
		else
		{
			return teacherRepository.save(taecherVO);
		}
		
	}

	public List<TeacherVO> getTeachersDetailByschId(Long schId) {
		// TODO Auto-generated method stub
		return teacherRepository.getTeachersDetailByschId(schId);
	}
}
