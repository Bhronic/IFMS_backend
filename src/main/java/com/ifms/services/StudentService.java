package com.ifms.services;

import java.util.List;

import com.ifms.models.User;

public interface StudentService {

	List<User> findByRoles_Id(Integer id);
}
