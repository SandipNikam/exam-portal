package com.springexamportal.service1;

import java.util.Set;

import com.springexamportal.model.User;
import com.springexamportal.model.UserRole;

public interface UserService {
	//create user
	User createUser(User user, Set<UserRole> userRoles) throws Exception;

	//get user by username
	public User getUser(String username);
	
	//delete user by id
	public void deleteUser(Long id);
	
	//update user
	public User updateUser(User user,Long id);
}
