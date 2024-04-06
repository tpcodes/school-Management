package com.schoolmanagement.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.repositories.CustomDao;
import com.repositories.UserRepository;
import com.schoolmanagement.entities.User;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CustomDao custumdao;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public List<User> getUsers()
	{
		return userRepository.findAll();	
		
	}
	
	public User createUser(User user)
	{
		User user1=userRepository.findByEmail(user.getEmail());
		if(user1!=null)
		{
			return null;
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}

	public List<Map<String, Object>> getstakeholderCount() {
		// TODO Auto-generated method stub
		return custumdao.getStakeholderCount();
	}

	public List<User> getAdminDetailsByschId() {
		// TODO Auto-generated method stub
		return custumdao.getAdminDetailsByschId();
	}
}
