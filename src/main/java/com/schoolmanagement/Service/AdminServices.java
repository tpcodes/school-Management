package com.schoolmanagement.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.repositories.AdminRepository;
import com.schoolmanagement.entities.AdminVO;
import com.schoolmanagement.entities.StudentVO;

@Service
public class AdminServices {
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<AdminVO> getAdmins()
	{
		return adminRepository.findAll();	
		
	}
	
	public AdminVO getadminById(Long adminId) {
		
		AdminVO admin=null;
		try
		{
			Optional<AdminVO> result=adminRepository.findById(adminId);
			admin=result.get();
			
//			student=.orElseThrow(()->new ResourceNotFoundException("Student not found with id " +stuId));
		}catch(NoSuchElementException e)
		{
			
		}
		return admin;
	}
	
	
//	public StudentVO getstudentByend(String fname) {
//		return studentRepository.findstudentwithend(fname);
//	}
	
	public AdminVO createAdmin(AdminVO admin)
	{
		AdminVO st=adminRepository.findByEmail(admin.getEmail());
		if(st!=null)
		{
			return null;
		}
		else
		{
			return adminRepository.save(admin);
		}

	}

	public List<AdminVO> getAdminDetailsByschId(Long schId) {
		// TODO Auto-generated method stub
		return adminRepository.getAdminsDetailByschId(schId);
	}
}
