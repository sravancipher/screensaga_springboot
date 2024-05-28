package com.rest.screensaga.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.screensaga.dao.UserDetailsDAO;
import com.rest.screensaga.dao.WatchlistDAO;
import com.rest.screensaga.entities.User;
import com.rest.screensaga.entities.Watchlist;
@Service
public class UserDetailsService {
	@Autowired
	private UserDetailsDAO userDetailsDAO;
	@Autowired
	private WatchlistDAO watchlistDAO;
	@Autowired
	private EmailService emailService;
	public Boolean createUser(User user) {
		List<User> u=userDetailsDAO.findAll();
		String email=user.getUser_mail();
		for(User u1:u) {
			System.out.println("u1");
			String mail=u1.getUser_mail();
			if(mail.equalsIgnoreCase(email)) {
				return false;
			}
		}
		userDetailsDAO.save(user);
		return true;
	}
	public Watchlist addwatchlist(Watchlist watchlist) {
		return watchlistDAO.save(watchlist);
	}
	public Boolean getUser(String user_mail,String user_pswd) {
		List<User> u=userDetailsDAO.findAll();
		for(User u1:u) {
			System.out.println(u1);
			String mail=u1.getUser_mail();
			String pswd=u1.getUser_pswd();
			if(mail.equalsIgnoreCase(user_mail)) {
				if(pswd.equalsIgnoreCase(user_pswd))
				return true;
			}
		}
		 return false;
	}
	
	public List<Watchlist> getWatchList(String user_mail) {
		List<Watchlist> u=watchlistDAO.findAll();
		List<Watchlist> users=new ArrayList<Watchlist>();
		int count=0;
		for(Watchlist u1:u) {
			System.out.println(u1);
			String mail=u1.getUser_mail();
				if(mail.equalsIgnoreCase(user_mail)) {
					count=1;
					users.add(u1);
				}
//				else {
//					throw new NoWatchDataException("Watchlist is Empty");
//				}
			
			
		}
		if(count==1) {
			return users;
		}
		return null;
	}
	public Watchlist deleteWatchList(String user_mail,String movie) {
		List<Watchlist> u=watchlistDAO.findAll();
		List<Watchlist> users=new ArrayList<Watchlist>();
		for(Watchlist u1:u) {
			String moviedb=u1.getMovie_name();
				if(moviedb.equalsIgnoreCase(movie)) {
					watchlistDAO.delete(u1);
					return u1;
				}
		}
		return null;

	}
	public Boolean sendMail(String user_mail) {
//		User u=userDetailsDAO.findById(user_mail).get();
		String user_mail1=user_mail.substring(0, -10);
		String resetlink="https://resetpasswordss.netlify.app/";
		String subject = " Password Reset Request";
        String text = "Dear"+ user_mail1+ ",\n\nWe have received a request to reset the password for your ScreenSaga account. To reset your password, please click on the link below:\n\n"+resetlink+"\n\nIf you did not request a password reset, please ignore this email.\n\n If you need further assistance, please feel free to reach out to us.\n\nThank you for using ScreenSaga.\n\nBest regards,\n\nScreenSaga Team\n\nEmail: screensagahelp@gmail.com\n\nThis is an auto-generated email. Please do not reply directly to this message.\n\n"
        		+ "\r\n"
        		+ "";
        emailService.sendEmail(user_mail, subject, text);
        
		return true;
	}
	public Boolean updatePassword(String user_mail,String user_password) {
//		User u=userDetailsDAO.findById(user_mail).get();
//		u.setUser_pswd(user_password);
//		User u1=userDetailsDAO.save(u);
//		String subject = "Password Update Notification";
//        String text = "Your password has been successfully updated.";
//        emailService.sendEmail(user_mail, subject, text);
//		return u1;
		List<User> u=userDetailsDAO.findAll();
		for(User u1:u) {
			System.out.println(u1);
			String mail=u1.getUser_mail();
			if(mail.equalsIgnoreCase(user_mail)) {
				u1.setUser_pswd(user_password);
				User u2=userDetailsDAO.save(u1);
				return true;
			}
		}
		 return false;
		
	}

}
//class NoWatchDataException extends Exception{
//	NoWatchDataException(String msg){
//		super(msg);
//	}
//	NoWatchDataException(){};
//	
//}
