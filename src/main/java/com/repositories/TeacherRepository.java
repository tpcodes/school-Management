package com.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.schoolmanagement.entities.TeacherVO;

@Repository
public interface TeacherRepository extends JpaRepository<TeacherVO,Long> {
	public TeacherVO findByEmail(String email);
	public Optional<TeacherVO> findById(Long tchrId);
	
	
	@Query("select tchr from TeacherVO tchr where tchr.tchr_schId =:schId ")
	public List<TeacherVO> getTeachersDetailByschId(@Param("schId") Long schId);
}
