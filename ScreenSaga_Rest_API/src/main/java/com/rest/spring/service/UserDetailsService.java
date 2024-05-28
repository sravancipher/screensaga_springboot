package com.rest.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.spring.dao.UserDetailsDAO;
import com.rest.spring.dao.WatchlistDAO;
import com.rest.spring.entities.User;
import com.rest.spring.entities.Watchlist;
@Service
public class UserDetailsService {
  @Autowired
  private UserDetailsDAO userDetailsDAO;
  @Autowired
  private WatchlistDAO watchlistDAO;
  
  public Boolean createUser(User user) {
	  List<User> users=userDetailsDAO.findAll();
	  for(User u:users) {
		  String mail=u.getUser_mail();
		  if(mail.equalsIgnoreCase(user.getUser_mail())) {
			  return false;
		  }
	  }
	  userDetailsDAO.save(user);
	  return true;
  }
  
  public Boolean getUser(String user_mail,String user_pswd) {
	  try {
		  User u=userDetailsDAO.findById(user_mail).get();
		  if(u.getUser_pswd().equalsIgnoreCase(user_pswd)) {
			  return true;
		  }
	  }
	  catch(Exception e) {
		  return false;
	  }
	  return false;
	  
  }
  
  public Boolean addWatchlist(Watchlist watchlist) {
	  watchlistDAO.save(watchlist);
	  return true;
  }
  
  public List<Watchlist> getWatchlist(String user_mail){
	  List<Watchlist> moviesadded=watchlistDAO.findAll();
	  List<Watchlist> movies=new ArrayList<Watchlist>();
	  for(Watchlist m:moviesadded) {
		  String mail=m.getUser_mail();
		  if(mail.equalsIgnoreCase(user_mail)) {
			  movies.add(m);
		  }
		  
	  }
	  return movies;
  }
  
  public String deleteWatchlist(String user_mail,String movie_name) {
	  List<Watchlist> moviesadded=watchlistDAO.findAll();
	  String text="";
	  for(Watchlist m:moviesadded) {
		  String mail=m.getUser_mail();
		  String movie=m.getMovie_name();
		  if(mail.equalsIgnoreCase(mail) && movie.equals(movie_name)) {
			  watchlistDAO.delete(m);
			  text=movie;
		  }
	  }
	  return text;
  }
  
  public Boolean updatePassword(String user_mail,String user_pswd) {
	  List<User> users=userDetailsDAO.findAll();
	  for(User u:users) {
		  String mail=u.getUser_mail();
		  if(mail.equalsIgnoreCase(user_mail)) {
			  u.setUser_pswd(user_pswd);
			  userDetailsDAO.save(u);
			  return true;
		  }
	  }
	  return false;
	  
  }
  
}
