package com.springexamportal;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.springexamportal.model.Role;
import com.springexamportal.model.User;
import com.springexamportal.model.UserRole;
import com.springexamportal.service1.UserService;

@SpringBootApplication
public class SpringexamportalApplication implements CommandLineRunner{
	
	@Autowired
	private UserService us;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringexamportalApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		
//		  User user=new User(); user.setFirstName("Rushikesh");
//		  user.setLastName("Londhe");
//		  user.setPassword(("abc"));
//			
//		  user.setEmail("rushikeshlondhe3385@gmail.com");
//		  user.setUsername("rushi123");
//		  
//		 Role role1=new Role(); 
//		 role1.setRoleId(44L); 
//		 role1.setRoleName("ADMIN");
//		  
//		  
//		  UserRole userRole=new UserRole();
//		  
//		  Set<UserRole> userRolesSet=new HashSet<>(); userRole.setRole(role1);
//		  userRole.setUser(user);
//		  
//		  userRolesSet.add(userRole);
//		  
//		  User createUser1 = this.us.createUser(user,userRolesSet);
//		  System.out.println(createUser1.getUsername());
//		 
	}

}
