package com.schoolmanagement.Contoller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.schoolmanagement.Service.RefreshTokenService;
import com.schoolmanagement.Service.UserService;
import com.schoolmanagement.config.CustomUserDetails;
import com.schoolmanagement.entities.RefreshToken;
import com.schoolmanagement.entities.User;
import com.schoolmanagement.model.JwtRequest;
import com.schoolmanagement.model.JwtResponse;
import com.schoolmanagement.model.RefreshTokenRequest;
import com.schoolmanagement.security.JwtHelper;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager manager;
    
    @Autowired
	private UserService userService;

    @Autowired
    private JwtHelper helper;

    @Autowired
    private RefreshTokenService refreshTokenService;
    
    private Logger logger = LoggerFactory.getLogger(AuthController.class);

 
    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {

        this.doAuthenticate(request.getEmail(), request.getPassword());


        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        String token = this.helper.generateToken(userDetails);
        
        RefreshToken refreshToken= refreshTokenService.createRefreshToken(userDetails.getUsername());

        JwtResponse response = JwtResponse.builder()
                .jwtToken(token)
                .refreshToken(refreshToken.getRefreshToken())
                .username(userDetails.getUsername()).build();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private void doAuthenticate(String email, String password) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
            manager.authenticate(authentication);


        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }

    }

    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }
    
    @PostMapping("/refresh")
    public JwtResponse refreshJwtToken(@RequestBody RefreshTokenRequest request)
    {
    	RefreshToken refreshToken=refreshTokenService.verifyRefreshToken(request.getRefreshToken());
    	
//    	User user =refreshToken.getUser();
    	User user=refreshToken.getUser();
    	CustomUserDetails customUserDetail=new CustomUserDetails(user);
    	String token=this.helper.generateToken(customUserDetail);
    	
    	return JwtResponse.builder().refreshToken(refreshToken.getRefreshToken())
    			.jwtToken(token)
    			.username(user.getEmail())
    			.build();
    	
    }
    
    @PostMapping("/create-user")
	public ResponseEntity<String> createUser(@RequestBody User user) {

		
		User user1 = userService.createUser(user);
		if (user1 != null) {
			return ResponseEntity.status(HttpStatus.OK).body("User is successfully registered!");

		} else {
			return ResponseEntity.status(HttpStatus.OK).body("User with given email already exist!");
		}
		
		
	}
//    @PostMapping("/create-user")
//    public User createUser(@RequestBody User user)
//    {
//    	return userService.createUser(user);
//    }
//    
////    @PostMapping("/create-student")
////    public StudentVO createStudent(@RequestBody StudentVO student)
////    {
////    	return studentServices.createStudent(student);
////    }
//    @PostMapping("/create-student")
//    public ResponseEntity<String> createStudent(@RequestBody StudentVO student)
//    {	
//    	studentServices.createStudent(student);
//    	
//    	
//    	return ResponseEntity.status(HttpStatus.OK).body("Student is successfully registered!");
//    	
//    
//    }
//    
//    @PostMapping("/create-school")
//    public SchoolVO createSchool(@RequestBody SchoolVO school)
//    {
//    	return schoolServices.createSchool(school);
//    }
}
