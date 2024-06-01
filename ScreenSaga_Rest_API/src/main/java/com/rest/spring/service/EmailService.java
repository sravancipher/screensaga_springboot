package com.rest.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.rest.spring.entities.User;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;
    
    public void sendAccountCreationMail(User user) {
    	SimpleMailMessage message = new SimpleMailMessage();
    	String username=user.getUser_mail().substring(0, user.getUser_mail().lastIndexOf('@'));;
    	String mail=user.getUser_mail();
    	String pswd=user.getUser_pswd();
    	message.setTo(mail);
    	message.setSubject("Welcome to ScreenSaga! Your Account Has Been Successfully Created");
    	String text="Dear "+username+"\n\nWe are thrilled to welcome you to ScreenSaga, your new destination for an incredible world of movies and web series!\n\nYour account has been successfully created, and you're now a part of our growing community of entertainment enthusiasts. Here are your account details:\n\nEmail: "+mail+"\n\nPassword: "+pswd+"\n\nWith your new ScreenSaga account, you can:\n\nExplore a vast library of movies and web series across various genres.\n\nCreate personalized watchlists to keep track of your favorite content.\n\nEnjoy seamless streaming on multiple devices.\n\nTo get started, simply log in to your account at https://screensaga.netlify.app/ using your username and password. If you have any questions or need assistance, our support team is here to help. You can reach us at screensagahelp@gmail.com\n\nWe hope you enjoy your experience with ScreenSaga. Stay tuned for regular updates, new releases, and exclusive content!\n\nHappy Watching!\n\nBest regards,\nThe ScreenSaga Team\n\nScreenSaga\nhttps://screensaga.netlify.app/\nscreensagahelp@gmail.com\n\nPlease do not reply to this email. This mailbox is not monitored, and you will not receive a response. For any queries, please contact our support team.";
    	message.setText(text);
    	emailSender.send(message);
    }

    public Boolean sendPasswordResetEmail(String to) {
    	String resetLink="https://resetpasswordss.netlify.app/";
        SimpleMailMessage message = new SimpleMailMessage();
        String username=to.substring(0, to.lastIndexOf('@'));;
        message.setTo(to);
        message.setSubject("Password Reset Request");
        message.setText("Dear "+ username+",\n\nWe have received a request to reset the password for your ScreenSaga account. To reset your password, please click on the link below:\n\n"+resetLink+"\n\nIf you did not request a password reset, please ignore this email.\n\nThank you for using ScreenSaga.\n\nBest regards,\n\nScreenSaga Team\n\nEmail: screensagahelp@gmail.com");
        
        emailSender.send(message);
        return true;
    }
    
    public void sendAccountDeletionMail(String user_mail) {
    	SimpleMailMessage message = new SimpleMailMessage();
    	String username=user_mail.substring(0, user_mail.lastIndexOf('@'));
    	message.setTo(user_mail);
    	message.setSubject("Account Deletion Confirmation");
    	String text="Dear "+username+",\n\nWe are writing to inform you that your ScreenSaga account has been successfully deleted as per your request. All your data associated with the account has been permanently removed from our system.\n\nIf you did not request this account deletion or if you have any concerns, please contact our support team immediately.\n\nThank you for being a part of the ScreenSaga community. We are sorry to see you go and hope to have the opportunity to serve you again in the future.\n\nBest regards,\n\nScreenSaga Team\n\nEmail: screensagahelp@gmail.com\n\nThis is an auto-generated email. Please do not reply directly to this message.";
    	message.setText(text);
    	emailSender.send(message);
    }
}
