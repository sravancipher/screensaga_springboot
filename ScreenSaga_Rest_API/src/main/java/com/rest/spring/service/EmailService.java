package com.rest.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

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
}
