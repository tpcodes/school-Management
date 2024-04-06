package com.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.schoolmanagement.entities.AdminVO;


public interface AdminRepository extends JpaRepository<AdminVO,Long> {
	public AdminVO findByEmail(String email);
	public Optional<AdminVO> findById(Long stuId);
	
	@Query("select admin from AdminVO admin where admin.admin_schId =:schId ")
	public List<AdminVO> getAdminsDetailByschId(@Param("schId") Long schId);

	
}
