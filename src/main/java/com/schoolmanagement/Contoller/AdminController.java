package com.schoolmanagement.Contoller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.schoolmanagement.Service.SchoolServices;
import com.schoolmanagement.Service.StudentServices;
import com.schoolmanagement.Service.UserService;
import com.schoolmanagement.entities.SchoolVO;
import com.schoolmanagement.entities.StudentVO;
import com.schoolmanagement.entities.User;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private UserService userService;

	@Autowired
	private SchoolServices schoolServices;

	@Autowired
	private StudentServices studentServices;

	
	@GetMapping("/user-detail")
	public List<User> getUsers(){
		return userService.getUsers();
	}
	
	@GetMapping("/student-detail")
	public ResponseEntity<List<StudentVO>> getStudentDetails() {
		List<StudentVO> studentList = this.studentServices.getStudents();
		if (studentList.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {
			return ResponseEntity.of(Optional.of(studentList));
		}

	}

	@GetMapping("/student-id")
	public ResponseEntity<StudentVO> getStudentDetailsByID(@RequestParam long stuId) {
		StudentVO student = this.studentServices.getstudentById(stuId);
		if (student == null) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		return ResponseEntity.of(Optional.of(student));
	}

	@GetMapping("/school-detail")
	public ResponseEntity<List<SchoolVO>> getSchoolDetails() {

		List<SchoolVO> schoolList = this.schoolServices.getSchools();
		if (schoolList.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {
			return ResponseEntity.of(Optional.of(schoolList));
		}

	}

	@GetMapping("/school-id")
	public ResponseEntity<SchoolVO> getSchoolDetailsByID(@RequestParam long schId) {

		SchoolVO school = this.schoolServices.getschoolById(schId);
		if (school == null) {

			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} else {

			return ResponseEntity.of(Optional.of(school));
		}

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

	
	
	
	@PostMapping("/create-student")
	public ResponseEntity<String> createStudent(@RequestBody StudentVO student) {

		StudentVO st = studentServices.createStudent(student);
		if (st != null) {
			return ResponseEntity.status(HttpStatus.OK).body("Student is successfully registered!");

		} else {
			return ResponseEntity.status(HttpStatus.OK).body("Student with given email already exist!");
		}

	}

	@PostMapping("/create-school")
	public ResponseEntity<String> createSchool(@RequestBody SchoolVO school) {

		SchoolVO sch = schoolServices.createSchool(school);
		;
		if (sch != null) {
			return ResponseEntity.status(HttpStatus.OK).body("School is successfully registered!");

		} else {
			return ResponseEntity.status(HttpStatus.OK).body("School with given email already exist!");
		}

	}
}
