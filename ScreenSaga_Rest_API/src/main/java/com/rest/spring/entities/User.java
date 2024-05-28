package com.rest.spring.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="user")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	@Column(name="usermail")
	private String user_mail;
			
	@Column(name="username")
	private String user_name;
	
	@Column(name="userpassword")
	private String user_pswd;
	
}
