package com.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.schoolmanagement.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,String>{
	public User findByEmail(String email);
	
	@Query("select u from User u where u.email =:email ")
	public User getUserByUserName(@Param("email") String email);
	
		
}
