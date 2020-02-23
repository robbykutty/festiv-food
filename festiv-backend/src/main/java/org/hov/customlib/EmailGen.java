package org.hov.customlib;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

public class EmailGen 
{
	public static String senderUsername;
	public static String senderPassword;
	
	static 
	{
		loadCredentials();
	}
	
	public static boolean loadCredentials()
	{
		senderUsername = "pvt.robin@gmail.com";
		senderPassword = "";
		return true;
	}

	public boolean sendEmail(String userEmail,
			                 String messageSubject,
			                 String messageBody)
	{
		try 
		{
			Email email = new SimpleEmail();
			email.setHostName("smtp.gmail.com.");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator(senderUsername, senderPassword));
			email.setSSLOnConnect(true);
			email.setFrom("pvt.robin@gmail.com");
			email.setSubject(messageSubject);
			email.setMsg(messageBody);
			email.addTo(userEmail);
			email.send();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public boolean generateEmail(int emailType,
							    String userEmail,
								String userName,
								String optionalCode,	//Optional Verification Code
								String optionalInfo)	//Optional Order Information
	{
		String messageSubject = "";
		String messageBody = "";
		
		switch(emailType)
		{
			case 1: //VERIFICATION EMAIL
				messageSubject = "Hola, Email Verification from Festiv Foodie!";
				messageBody = generateHTMLBody(emailType, userName, optionalCode, optionalInfo);
				break;
				
			case 2: //"PASSWORD_CHANGE EMAIL
				messageSubject = "Hola, Password Change Code from Festive Foodie!";
				messageBody = generateHTMLBody(emailType, userName, optionalCode, optionalInfo);
				break;
				
			case 3: //PAYMENT PENDING EMAIL
				messageSubject = "";
				messageBody = generateHTMLBody(emailType, userName, optionalCode, optionalInfo);
				break;
				
			case 4: //PAYMENT COMPLETE EMAIL
				messageSubject = "";
				messageBody = generateHTMLBody(emailType, userName, optionalCode, optionalInfo);
				break;
				
			case 5: //ORDER DELIVERED EMAIL
				messageSubject = "";
				messageBody = generateHTMLBody(emailType, userName, optionalCode, optionalInfo);
				break;
				
			case 6: //ORDER RETURN EMAIL
				messageSubject = "";
				messageBody = generateHTMLBody(emailType, userName, optionalCode, optionalInfo);
				break;
				
			case 7: //ORDER REFUND EMAIL
				messageSubject = "";
				messageBody = generateHTMLBody(emailType, userName, optionalCode, optionalInfo);
				break;
		}
		
		if(sendEmail(userEmail, messageSubject, messageBody))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
		
	public String generateHTMLBody(int type, String name, String code, String info)
	{
		String body = null;
		
		switch(type)
		{
			case 1: //VERIFICATION EMAIL
				body = "";
				break;

			case 2: //"PASSWORD_CHANGE EMAIL
				body = "";
				break;

			case 3: //PAYMENT PENDING EMAIL
				body = "";
				break;

			case 4: //PAYMENT COMPLETE EMAIL
				body = "";
				break;

			case 5: //ORDER DELIVERED EMAIL
				body = "";
				break;

			case 6: //ORDER RETURN EMAIL
				body = "";
				break;

			case 7: //ORDER REFUND EMAIL
				body = "";
				break;
		}
		return body;
	}
}
