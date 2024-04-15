package com.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.schoolmanagement.entities.SubjectVO;

@Repository
public interface SubjectRepository  extends JpaRepository<SubjectVO,Long>{

//	public subjectVO findByEmail(String email);
	public Optional<SubjectVO> findById(Long subId);

	@Query("select subject from SubjectVO subject where subject.subCode =:subCode ")
	public SubjectVO findBySubCode(@Param("subCode") String subCode);
	



	
}
