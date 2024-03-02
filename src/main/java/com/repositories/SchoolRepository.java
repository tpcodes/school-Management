package com.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.schoolmanagement.entities.SchoolVO;

@Repository
public interface SchoolRepository extends JpaRepository<SchoolVO,Long>{

	public SchoolVO findByEmail(String email);
	public Optional<SchoolVO> findById(Long schId);
	
}
