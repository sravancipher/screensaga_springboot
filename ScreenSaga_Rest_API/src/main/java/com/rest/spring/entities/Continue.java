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
@Table(name="continuewatch")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Continue {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	@Column(name="usermail")
	private String user_mail;
	@Column(name="videotype")
	private String video_type;
	@Column(name="moviename")
	private String movie_name;
	@Column(name="movieimage")
	private String movie_image;
	
}
