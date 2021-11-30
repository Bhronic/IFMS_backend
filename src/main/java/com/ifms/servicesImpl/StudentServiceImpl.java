package com.ifms.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifms.models.User;
import com.ifms.repository.UserRepository;
import com.ifms.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findByRoles_Id(Integer id) {
		return userRepository.findByRoles_Id(id);
	}

}
