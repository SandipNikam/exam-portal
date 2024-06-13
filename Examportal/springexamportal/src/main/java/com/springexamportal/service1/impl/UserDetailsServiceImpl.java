package com.springexamportal.service1.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springexamportal.model.User;
import com.springexamportal.repository.UserRepo;
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
	private UserRepo ur;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	User user = this.ur.findByUsername(username);
	if(user==null) {
		System.out.println("user not found");
		throw new UsernameNotFoundException("No user found !!");
	}
		return user;
	}

}
