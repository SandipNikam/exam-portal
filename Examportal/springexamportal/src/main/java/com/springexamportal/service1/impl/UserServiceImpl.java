package com.springexamportal.service1.impl;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springexamportal.model.User;
import com.springexamportal.model.UserRole;
import com.springexamportal.repository.RoleRepo;
import com.springexamportal.repository.UserRepo;
import com.springexamportal.service1.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo ur;

	@Autowired
	private RoleRepo rr;
	
	//creating user
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception{
		
		User local=this.ur.findByUsername(user.getUsername());
		
		if(local!=null) {
			System.out.println("User is already exist");
			
			throw new Exception("User already exist");
		}
		else {
			for(UserRole ur:userRoles) {
				rr.save(ur.getRole());
			}
			user.getUserRoles().addAll(userRoles);		
			local = this.ur.save(user);
		
			return local;
		}
		
		
	}
//get user by username
	@Override
	public User getUser(String username) {
		
		return this.ur.findByUsername(username);
	}
	
	//delete user by id
	@Override
	public void deleteUser(Long id) {
	
		this.ur.deleteById(id);
	}
	//update
	@Override
	public User updateUser(User user, Long id) {
		User oldUser=this.ur.getUserById(id);
		oldUser.setUsername(user.getUsername());
		oldUser.setPassword(user.getPassword());
		oldUser.setFirstName(user.getFirstName());
		oldUser.setLastName(user.getLastName());
		oldUser.setEmail(user.getEmail());
		oldUser.setPhone(user.getPhone());
		oldUser.setProfile(user.getProfile());
		
		oldUser.setUserRoles(user.getUserRoles());
		User save = this.ur.save(oldUser);
		return save;
	}
	

	
}
