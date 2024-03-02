package com.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.schoolmanagement.entities.StudentVO;

@Repository
public interface StudentRepository extends JpaRepository<StudentVO,Long> {
	public StudentVO findByEmail(String email);
	public Optional<StudentVO> findById(Long stuId);

//	
//	@Query("select email from students where stu_fname like %?1")
//	StudentVO findstudentwithend(String fname);
}
