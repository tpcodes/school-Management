//package com.schoolmanagement.Service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.repositories.StudentRepository;
//
//import com.schoolmanagement.entities.StudentVO;
//
//
//import jakarta.persistence.EntityNotFoundException;
//
//@Service
//public class CustomStudentDetailService implements UserDetailsService{
//
//	
//	@Autowired
//	private StudentRepository studentRepository ;
//	
//	
//	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		
//		StudentVO studentVO=studentRepository.findByEmail(username).orElseThrow(()-> new RuntimeException("student not found!!"));
//		
//		// load user from database
//		
//			return studentVO;
//		
//	}
//	
//	public UserDetails loadStudentByUserID(Long stuId) throws EntityNotFoundException {
//		
//		StudentVO studentVO=studentRepository.findById(stuId).orElseThrow(()->new EntityNotFoundException("Student not found with id " +stuId));
//		
//		// load user from database
//		
//		return studentVO;
//		
//	}
//	
//	
//	
//}



