package com.springexamportal.controller;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springexamportal.config.JwtTokenHelper;
import com.springexamportal.model.JwtRequest;
import com.springexamportal.model.JwtResposne;
import com.springexamportal.model.Role;
import com.springexamportal.model.User;
import com.springexamportal.model.UserRole;
import com.springexamportal.service1.impl.UserDetailsServiceImpl;

@RestController
@CrossOrigin("*")
public class AuthenitcateController {

	@Autowired
	private AuthenticationManager am;
	
	@Autowired
	private UserDetailsServiceImpl us;
	
	@Autowired
	private JwtTokenHelper helper;
	
	
	
	 
	 
	
	
	//generate token
	@PostMapping("/generate-token")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		
		try {
			this.authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
		}catch(UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("user not found");
		}
		//authentication done
		UserDetails userDetails = this.us.loadUserByUsername(jwtRequest.getUsername());
		String token = this.helper.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResposne(token));
	}
	
	
	private void authenticate(String username,String password) throws Exception {
		try {
			am.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		}
		catch(DisabledException e) {
			throw new Exception("USER DISABLED");
		}
		catch(BadCredentialsException e) {
			throw new Exception("Invalid Credentials");
		}
	}
	
	//getting current user
	@GetMapping("/current-user")
	public User getCurrentUser(Principal p) {
		return ((User)this.us.loadUserByUsername(p.getName()));
	} 
}
