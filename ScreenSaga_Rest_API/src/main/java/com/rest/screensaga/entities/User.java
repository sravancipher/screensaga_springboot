package com.rest.screensaga.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name="user")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {
	@Column(name="username")
	private String user_name;
	@Id
	@Column(name="usermail")
	private String user_mail;
	@Column(name="userpassword")
	private String user_pswd;
}
