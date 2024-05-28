package com.rest.spring.entities;

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
@Table(name="watchlist")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Watchlist {
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	@Column(name="idnumber")
	private Integer id;
	
	@Column(name="usermail")
	private String user_mail;
	
	@Column(name="moviename")
	private String movie_name;
	
	@Column(name="image")
	private String movie_image;

}
