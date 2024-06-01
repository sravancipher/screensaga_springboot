package com.rest.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.spring.dao.ContactDAO;
import com.rest.spring.dao.UserDetailsDAO;
import com.rest.spring.dao.WatchlistDAO;
import com.rest.spring.entities.Contact;
import com.rest.spring.entities.User;
import com.rest.spring.entities.Watchlist;
@Service
public class UserDetailsService {
  @Autowired
  private UserDetailsDAO userDetailsDAO;
  @Autowired
  private WatchlistDAO watchlistDAO;
  @Autowired 
  private ContactDAO contactDAO;
  @Autowired
  private EmailService emailService;
  public Boolean createUser(User user) {
	  List<User> users=userDetailsDAO.findAll();
	  for(User u:users) {
		  String mail=u.getUser_mail();
		  if(mail.equalsIgnoreCase(user.getUser_mail())) {
			  return false;
		  }
	  }
	  userDetailsDAO.save(user);
	  emailService.sendAccountCreationMail(user);
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
  
  public Boolean addComment(Contact comment) {
	  contactDAO.save(comment);
	  return true;
  }
  
  public Boolean deleteaccount(String user_mail) {
	  userDetailsDAO.deleteById(user_mail);
	  try {
		  List<Watchlist> watchlistdata=watchlistDAO.findAll();
		  List<Contact> contactdata=contactDAO.findAll();
		  for(Watchlist w:watchlistdata) {
			  if(w.getUser_mail().equalsIgnoreCase(user_mail)) {
				  watchlistDAO.delete(w);
			  }
		  }
		  for(Contact c:contactdata) {
			  if(c.getUsermail().equalsIgnoreCase(user_mail)) {
				  contactDAO.delete(c);
			  }
		  }
	  }
	  catch(Exception e) {
		  return true;
	  }
	  emailService.sendAccountDeletionMail(user_mail);
	  return true;
	  
  }
}
