package com.schoolmanagement.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repositories.StaffRepository;
import com.schoolmanagement.entities.StaffVO;

@Service
public class StaffService {
	@Autowired
	private StaffRepository staffRepository;
	
	public List<StaffVO> getStaffs()
	{
		return staffRepository.findAll();	
		
	}
	
	public StaffVO getStaffById(Long staffId) {
		
		StaffVO staff=null;
		try
		{
			Optional<StaffVO> result=staffRepository.findById(staffId);
			staff=result.get();
			
		}catch(NoSuchElementException e)
		{
			
		}
		return staff;
	}
	
	
	public StaffVO createStaff(StaffVO staffvo)
	{

		StaffVO staff=staffRepository.findByEmail(staffvo.getEmail());
		if(staff!=null)
		{
			return null;
		}
		else
		{
			return staffRepository.save(staffvo);
		}
		
	}

	public List<StaffVO> getStaffDtlsBySchId(Long schId) {
		// TODO Auto-generated method stub
		return staffRepository.getStaffDtlsBySchId(schId);
	}
}
