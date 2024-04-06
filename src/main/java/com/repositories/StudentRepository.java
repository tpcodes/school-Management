package com.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.schoolmanagement.entities.StudentVO;
import com.schoolmanagement.entities.User;

@Repository
public interface StudentRepository extends JpaRepository<StudentVO,Long> {
	public StudentVO findByEmail(String email);
	public Optional<StudentVO> findById(Long stuId);
	
	@Query("select stu from StudentVO stu where stu.stu_schId =:schId ")
	public List<StudentVO> getStudentDetailByschId(@Param("schId") Long schId);
	
	
//	@Query("select u from User u where u.email =:email ")
//	public User getUserByUserName(@Param("email") String email);
//	
//	@Query("select email from students where stu_fname like %?1")
//	StudentVO findstudentwithend(String fname);
}
