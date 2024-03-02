package com.schoolmanagement.Contoller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolmanagement.Service.UserService;
import com.schoolmanagement.entities.User;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/user-detail")
	public List<User> getUsers(){
		return userService.getUsers();
	}
	
	@GetMapping("/current-user-detail")
	public String getLoggedInUserDetails(Principal principal)
	{
		
		return principal.getName();
	}
}
