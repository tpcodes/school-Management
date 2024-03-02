package com.schoolmanagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.repositories.UserRepository;
import com.schoolmanagement.config.CustomUserDetails;
import com.schoolmanagement.entities.User;

@Primary
@Service
public class CustomUserdetailService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository ;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user=userRepository.getUserByUserName(username);
		// load user from database
		if(user==null)
		{
			throw new UsernameNotFoundException("User does not exist !");
		}
		CustomUserDetails customUserDetail=new CustomUserDetails(user);
		return customUserDetail;
	}

}
