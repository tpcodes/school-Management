package com.schoolmanagement.Contoller;

import java.security.Principal;
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

import com.schoolmanagement.Service.StudentServices;
import com.schoolmanagement.entities.StudentVO;


@RestController
@RequestMapping("/student")
public class studentController {

	@Autowired
	private StudentServices studentServices;
	
//	@PostMapping("/student-detail")
//	public int saveStudentDetails(@RequestBody StudentVO studentVo)
//	{
////		StudentVO studentVO=new StudentVO();
//		return 1;
////		return this.studentService.saveStudentDetails(studentVo);
//	}
	
	@GetMapping("/students-detail")
	public ResponseEntity<List<StudentVO>> getStudentDetails()
	{
		List<StudentVO> studentList=this.studentServices.getStudents();
		if(studentList.size()<=0)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		else
		{
			return ResponseEntity.of(Optional.of(studentList));
		}
		
		
	}
	
	@GetMapping("/student-id")
	public ResponseEntity<StudentVO>  getStudentDetailsByID(@RequestParam long stuId)
	{
		StudentVO student=this.studentServices.getstudentById(stuId);
		if(student==null)
		{
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	
		return ResponseEntity.of(Optional.of(student));
	}
	
	
//	@GetMapping("/student/fname-search")
//	public StudentVO getstudentByend(@RequestParam String fname)
//	{
//		return this.studentServices.getstudentByend(fname);
//	}
	
	@GetMapping("/current-student-detail")
	public String getLoggedInStudentDetails(Principal principal)
	{
		
		return principal.getName();
	}
	
}
