package com.ifms.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifms.models.User;
import com.ifms.services.StudentService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/faculty")
public class FacultyController {

	@Autowired
	private StudentService studentService;

	
	@GetMapping("/getUserByRole")
	@PreAuthorize("hasRole('STUDENT')") 
	public List<User> findByRole() 
	{
		Integer id = 5;
		List<User> usr =  studentService.findByRoles_Id(id);	
		return usr;
	}
}
