package com.rest.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.spring.entities.Contact;
import com.rest.spring.entities.User;
import com.rest.spring.entities.Watchlist;
import com.rest.spring.service.EmailService;
import com.rest.spring.service.UserDetailsService;
//@CrossOrigin(origins= {"http://localhost:8081/","http://localhost:3001/","http://localhost:3000"})
@CrossOrigin(origins= {"http://localhost:8081/","https://resetpasswordss.netlify.app/","https://screensaga.netlify.app/"})
@RestController
@RequestMapping(value="/user")
public class UserDetailsController {
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private EmailService emailService;
	@PostMapping(value="/signup")
	public Boolean createUser(@RequestBody User user) {
		return userDetailsService.createUser(user);
	}
	@GetMapping(value="/login/{user_mail}/{user_pswd}")
	public Boolean createUser(@PathVariable("user_mail") String user_mail,@PathVariable("user_pswd") String user_pswd) {
		return userDetailsService.getUser(user_mail,user_pswd);
	}
	@PostMapping(value="/addwatchlist")
	public Boolean addWatchlist(@RequestBody Watchlist watchlist) {
		return userDetailsService.addWatchlist(watchlist);
	}
	
	@GetMapping(value="/getwatchlist/{user_mail}")
	public List<Watchlist> getWatchlist(@PathVariable("user_mail") String user_mail){
		return userDetailsService.getWatchlist(user_mail);
	}
	@DeleteMapping(value="/deletewatchlist/{user_mail}/{movie_name}")
	public String deleteWatchlist(@PathVariable("user_mail") String user_mail,@PathVariable("movie_name") String movie_name){
		return userDetailsService.deleteWatchlist(user_mail,movie_name);
	}
	@PutMapping(value="/sendmail/{user_mail}")
	public Boolean sendMail(@PathVariable("user_mail") String user_mail) {
		return emailService.sendPasswordResetEmail(user_mail);
	}
	
	@PutMapping(value="/updatepassword/{user_mail}/{user_pswd}")
	public Boolean updatePassword(@PathVariable("user_mail") String user_mail,@PathVariable("user_pswd") String user_pswd) {
		return userDetailsService.updatePassword(user_mail,user_pswd);
	}
	
	@PostMapping(value="/addcomment")
	public Boolean addComment(@RequestBody Contact comment) {
		return userDetailsService.addComment(comment);
	}
}
