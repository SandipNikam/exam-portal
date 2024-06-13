package com.springexamportal.model;



import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class UserRole {


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long userRoleId;
	
	// many roles - one user
	@ManyToOne(fetch=FetchType.EAGER)
	private User user;
	
	// many users - one role
	@ManyToOne
		private Role role;

		public UserRole() {
			super();
			// TODO Auto-generated constructor stub
		}

		public UserRole(Long userRoleId, User user, Role role) {
			super();
			this.userRoleId = userRoleId;
			this.user = user;
			this.role = role;
		}

		public Long getUserRoleId() {
			return userRoleId;
		}

		public void setUserRoleId(Long userRoleId) {
			this.userRoleId = userRoleId;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public Role getRole() {
			return role;
		}

		public void setRole(Role role) {
			this.role = role;
		}
		
		
}
