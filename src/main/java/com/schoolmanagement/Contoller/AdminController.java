package com.schoolmanagement.Contoller;


import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;
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

import com.schoolmanagement.Service.AdminServices;
import com.schoolmanagement.Service.SchoolServices;
import com.schoolmanagement.Service.StaffService;
import com.schoolmanagement.Service.StudentServices;
import com.schoolmanagement.Service.TeacherService;
import com.schoolmanagement.Service.UserService;
import com.schoolmanagement.entities.AdminVO;
import com.schoolmanagement.entities.SchoolVO;
import com.schoolmanagement.entities.StaffVO;
import com.schoolmanagement.entities.StudentVO;
import com.schoolmanagement.entities.TeacherVO;
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
	
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private StaffService staffServive;
	@Autowired
	private AdminServices adminServices;

	
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

//	@PostMapping("/create-user")
//	public ResponseEntity<String> createUser(@RequestBody User user) {
//
//		
//		User user1 = userService.createUser(user);
//		if (user1 != null) {
//			return ResponseEntity.status(HttpStatus.OK).body("User is successfully registered!");
//
//		} else {
//			return ResponseEntity.status(HttpStatus.OK).body("User with given email already exist!");
//		}
//		
//		
//	}

	
	
	
	@PostMapping("/create-admin")
	public ResponseEntity<String> createAdmin(@RequestBody AdminVO admin) {
		User user1=null;
		if(admin.getUser()!=null)
		{
			
			admin.getUser().setRole("ROLE_ADMIN");
			admin.getUser().setRoleId(1l);
			admin.getUser().setActive(1);		
			admin.getUser().setUserSchId(admin.getAdmin_schId());
			admin.getUser().setName(admin.getAdminFname()+" "+admin.getAdminLname());
			admin.setEmail(admin.getUser().getEmail());
			user1 = userService.createUser(admin.getUser());
	
		}
		admin.setRoleId(2l);
		admin.setCrtDate(new Date());
		AdminVO admin1=new AdminVO();
		admin1=null;
		if(user1!=null)
		{
			admin.getUser().setUserId(user1.getUserId());
			
			admin1 = adminServices.createAdmin(admin);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.OK).body("Admin with given email already exist!");
		}
		
		if (admin1 != null) {
			return ResponseEntity.status(HttpStatus.OK).body("Admin is successfully registered!");

		} else {
			return ResponseEntity.status(HttpStatus.OK).body("Admin with given email already exist!");
		}

	}
	@PostMapping("/create-student")
	public ResponseEntity<String> createStudent(@RequestBody StudentVO student) {
		User user1=null;
		if(student.getUser()!=null)
		{
			
			student.getUser().setRole("ROLE_STUDENT");
			student.getUser().setRoleId(2l);
			student.getUser().setActive(1);		
			student.getUser().setUserSchId(student.getStu_schId());
			student.getUser().setName(student.getStuFname()+" "+student.getStuLname());
			student.setEmail(student.getUser().getEmail());
			user1 = userService.createUser(student.getUser());
			
		}
		student.setRoleId(2l);
		student.setCrtDate(new Date());
		StudentVO st=new StudentVO();
		st=null;
		if(user1!=null)
		{
			student.getUser().setUserId(user1.getUserId());
			
			st = studentServices.createStudent(student);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.OK).body("Student with given email already exist!");
		}
		
		if (st != null) {
			return ResponseEntity.status(HttpStatus.OK).body("Student is successfully registered!");
			
		} else {
			return ResponseEntity.status(HttpStatus.OK).body("Student with given email already exist!");
		}
		
	}
	
	
	@PostMapping("/create-teacher")
	public ResponseEntity<String> createTeacher(@RequestBody TeacherVO teacherVO) {
		User user1=null;
		if(teacherVO.getUser()!=null)
		{
			teacherVO.getUser().setRole("ROLE_TEACHER");
			teacherVO.getUser().setRoleId(3l);
			teacherVO.getUser().setActive(1);
			teacherVO.getUser().setUserSchId(teacherVO.getTchr_schId());
			teacherVO.getUser().setName(teacherVO.getTchrFname()+" "+teacherVO.getTchrLname());
			teacherVO.setEmail(teacherVO.getUser().getEmail());
			user1 = userService.createUser(teacherVO.getUser());
			
		}
		teacherVO.setRoleId(3l);
		teacherVO.setCrtDate(new Date());
		TeacherVO tchr=new TeacherVO();
		tchr=null;
		if(user1!=null)
		{
			teacherVO.getUser().setUserId(user1.getUserId());
			
			tchr = teacherService.createTeacher(teacherVO);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.OK).body("Teacher with given email already exist!");
		}
		
		if (tchr != null) {
			return ResponseEntity.status(HttpStatus.OK).body("Teacher is successfully registered!");
			
		} else {
			return ResponseEntity.status(HttpStatus.OK).body("Teacher with given email already exist!");
		}
		
	}
	
	@PostMapping("/create-staff")
	public ResponseEntity<String> createStaff(@RequestBody StaffVO staffVO) {
		User user1=null;
		if(staffVO.getUser()!=null)
		{
			staffVO.getUser().setRole("ROLE_STAFF");
			staffVO.getUser().setRoleId(4l);
			staffVO.getUser().setActive(1);
			staffVO.getUser().setUserSchId(staffVO.getStaff_schId());
			staffVO.getUser().setName(staffVO.getStaffFname()+" "+staffVO.getStaffLname());
			staffVO.setEmail(staffVO.getUser().getEmail());
			user1 = userService.createUser(staffVO.getUser());
			
		}
		staffVO.setRoleId(4l);
		staffVO.setCrtDate(new Date());
		StaffVO staff=new StaffVO();
		staff=null;
		if(user1!=null)
		{
			staffVO.getUser().setUserId(user1.getUserId());
			
			staff= staffServive.createStaff(staffVO);
		}
		else
		{
			return ResponseEntity.status(HttpStatus.OK).body("Staff with given email already exist!");
		}
		
		if (staff != null) {
			return ResponseEntity.status(HttpStatus.OK).body("Staff is successfully registered!");
			
		} else {
			return ResponseEntity.status(HttpStatus.OK).body("Staff with given email already exist!");
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
	
	@GetMapping("/get-stkholder-count-dtls")
	public List<Map<String, Object>> getStkholderCount(@RequestParam Long schId) throws ParseException
	{
		return userService.getstakeholderCount(schId);
	}
	
	@GetMapping("/get-admins-dtl")
	public List<AdminVO> getAdminDetailsByschId(@RequestParam Long schId)
	{
	   return adminServices.getAdminDetailsByschId(schId);
	}
	@GetMapping("/get-students-dtl")
	public List<StudentVO> getstudentsByschId(@RequestParam Long schId)
	{
		return studentServices.getStudentsDetailsByschId(schId);
	}
	@GetMapping("/get-teachers-dtl")
	public List<TeacherVO> getTeacherByschId(@RequestParam Long schId)
	{
		return teacherService.getTeachersDetailByschId(schId);
	}
	@GetMapping("/get-staffs-dtl")
	public List<StaffVO> getStaffByschId(@RequestParam Long schId)
	{
		return staffServive.getStaffDtlsBySchId(schId);
	}
}
