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
@Table(name="watchlist")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Watchlist {
	@Id
	@Column(name="idnumber")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="usermail")
	private String user_mail;
	@Column(name="moviename")
	private String movie_name;
	@Column(name="image")
	private String movie_image;
//	@Column(name="watchlaterbtn")
//	private String watch_later_btn;
}
