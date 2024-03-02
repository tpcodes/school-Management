package com.schoolmanagement.Contoller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.schoolmanagement.Service.SchoolServices;
import com.schoolmanagement.entities.SchoolVO;
import com.schoolmanagement.entities.StudentVO;

@RestController
@RequestMapping("/school")
public class schoolController {

	@Autowired
	private SchoolServices schoolServices;

	@GetMapping("/school-detail")
	public List<SchoolVO> getSchoolDetails() {

		return this.schoolServices.getSchools();
	}

	@GetMapping("/school-id")
	public SchoolVO getSchoolDetailsByID(@RequestParam long schId) {

		return this.schoolServices.getschoolById(schId);
	}

	@GetMapping("/current-school-detail")
	public String getLoggedInSchoolDetails(Principal principal) {

		return principal.getName();
	}
}
