package com.rest.screensaga.controller;

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

import com.rest.screensaga.entities.User;
import com.rest.screensaga.entities.Watchlist;
import com.rest.screensaga.service.UserDetailsService;

@RestController
//@CrossOrigin(origins="http://localhost:3000/",methods = {RequestMethod.GET, RequestMethod.POST})
@CrossOrigin(origins={"http://localhost:3000/","https://resetpasswordss.netlify.app/"})

@RequestMapping(value="/user")
public class UserDetailsController {
	@Autowired
	private UserDetailsService userDetailsService;
	@PostMapping(value="/signup")
	public Boolean createUser(@RequestBody User user){
		Boolean res= userDetailsService.createUser(user);
		return res;
	}
	@PostMapping(value="/addwatchlist")
	public Watchlist addwatchlist(@RequestBody Watchlist watchlist) {
		return userDetailsService.addwatchlist(watchlist);
	}
	@GetMapping(value="/login/{user_mail}/{user_pswd}")
	public Boolean getUser(@PathVariable("user_mail") String user_mail,@PathVariable("user_pswd") String user_pswd) {
		Boolean res= userDetailsService.getUser(user_mail,user_pswd);
		return res;
	}
	@GetMapping(value="/getwatchlist/{user_mail}")
	public List<Watchlist> getWatchList(@PathVariable("user_mail") String user_mail) {
			return userDetailsService.getWatchList(user_mail);
	}
	@DeleteMapping(value="/deletewatchlist/{user_mail}/{movie}")
	public Watchlist deleteWatchList(@PathVariable("user_mail") String user_mail, @PathVariable("movie") String movie) {
			return userDetailsService.deleteWatchList(user_mail,movie);
	}
	@PutMapping(value="/sendmail/{user_mail}")
	public Boolean sendMail(@PathVariable("user_mail") String user_mail) {
		 return userDetailsService.sendMail(user_mail);
		 
	}
	@PutMapping(value="/updatepassword/{user_mail}/{user_pswd}")
	public Boolean updatePassword(@PathVariable("user_mail") String user_mail,@PathVariable("user_pswd") String user_password) {
		return userDetailsService.updatePassword(user_mail,user_password);
	}
	


}
