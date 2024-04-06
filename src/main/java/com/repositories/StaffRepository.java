package com.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.schoolmanagement.entities.StaffVO;
import com.schoolmanagement.entities.TeacherVO;


@Repository
public interface StaffRepository extends JpaRepository<StaffVO,Long> {
	public StaffVO findByEmail(String email);
	public Optional<StaffVO> findById(Long staffId);
	
	
	
	@Query("select staff from StaffVO staff where staff.staff_schId =:schId ")
	public List<StaffVO> getStaffDtlsBySchId(@Param("schId") Long schId);
}
