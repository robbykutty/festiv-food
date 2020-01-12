package org.hov.customlib;

import java.util.Random;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

public class EmailOperations 
{
	public String sendEmail(String name, String recipientEmail, int emailType)
	{
		//Build Email
		String verificationCode="";
		String subject=""; 
		String message="";
		
		switch(emailType)
		{
			case 1:		//Email Verification
				verificationCode = generateCode(6);
				subject = "Hola, Email Verification from Festiv Foodie!";
				message = "Hello "+ name + "," +
						  "" + //nextLine
						  "Your Eamil Verification Code is " + verificationCode + 
						  ". Enter the verification code to activate your account." + 
						  "" + //nextLine
						  "Please ignore if you did not sign up for Festiv Foodie account" +
						  "" + //nextLine
						  "Please Note: For security reasons, never share verification codes with any other person." +
						  "Foodie Festive never asks for verification code through phone or any other mode of communication.";
				break;
				
			case 2:		//Password Change
				verificationCode = generateCode(6);
				subject = "Hola, Password Change Code from Festive Foodie!";
				message = "Hello "+ name + "," +
						  "" + //nextLine
						  "Your Password Change Code is " + verificationCode + 
						  ". Enter the Code to change password." + 
						  "" + //nextLine
						  "Please ignore if you did not sign up for Festiv Foodie account" +
						  "" + //nextLine
						  "Please Note: For security reasons, never share verification codes with any other person." +
						  "Foodie Festive never asks for verification code through phone or any other mode of communication.";
				break;
				
			default:				
				break;
		}

		try 
		{
			//Send Email
			Email email = new SimpleEmail();
			//email.setHostName("smtp.googlemail.com");
			email.setHostName("smtp.gmail.com.");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("emailremoved", "passwordremoved"));
			email.setSSLOnConnect(true);
			email.setFrom("pvt.robin@gmail.com");
			email.setSubject(subject);
			email.setMsg(message);
			email.addTo(recipientEmail);
			email.send();
			
		}
		catch(Exception e)
		{
			System.out.println("Email Exception Due To->-- " + e);
			return "";
		}
		
		return verificationCode;
	}

	public String sendVerificationEmail(String name, String email)
	{
		return sendEmail(name, email, 1);		
	}
	
	public String sendPasswordChangeEmail(String name, String email)
	{
		return sendEmail(name, email, 2);		
	}
	
	//Generate Code
	public String generateCode(int length)
	{	
		int no=1;
		String randomNumber="";	
		Random rand = new Random(); 
		
		while(length > 0)
		{
			no*=10;
			length--;
		}
		
        randomNumber = Integer.toString(rand.nextInt(no));	
		return randomNumber;
	}
	
	public String sendHTMLEmail(String name, String recipientEmail, int emailType)
	{
		
			return "";
	}

}
