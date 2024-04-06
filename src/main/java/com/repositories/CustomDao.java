package com.repositories;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.schoolmanagement.entities.User;

@Repository
public class CustomDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	public List<Map<String, Object>> getStakeholderCount()
	{
		String sql = """
		           select 
case when u.role_id=1 then 'Admin_count'  
 when  u.role_id=2 then 'student count' 
 when u.role_id=3 then 'Teacher count' 
when u.role_id=4 then 'staff count' end as stkholdertype,
Case when u.role_id=1 then count(u.user_id) 
when u.role_id=2 then count(u.user_id) 
when u.role_id=3 
then count(u.user_id) when u.role_id=4 then count(u.user_id) end as count
from users u  where u.user_sch_id=1 group by u.role_id;
		     
		                 """;

		List<Map<String, Object>> obj=jdbcTemplate.queryForList(sql);
		   
		return obj;
				   
				   
	}


	public List<User> getAdminDetailsByschId() {
		// TODO Auto-generated method stub
		String sql = """
		           ;
		     
		                 """;

		List<Map<String, Object>> obj=jdbcTemplate.queryForList(sql);
		   
		return null;
	}
}
