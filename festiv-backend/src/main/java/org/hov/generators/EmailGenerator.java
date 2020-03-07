package org.hov.generators;

import org.apache.commons.mail.Email;
import org.hov.config.EmailConfig;
import org.hov.enumerators.EmailType;

public class EmailGenerator 
{
	String messageSubject;
	String messageBody;
	
	public boolean send(EmailType emailType, 
					    String 	  userName, 
					    String    userEmail,
					    Double    OrderAmount,
					    String    OrderDescription,
					    String    verificationCode)
	{
		messageSubject = "";
		messageBody = "";
		Email email;
		
		try 
		{
			email = EmailConfig.getEmailProperties();
			email.addTo(userEmail);

			switch(emailType)
			{
				case VERIFICATION:
					messageSubject = "Hi " + userName + ". Email Verification from Festiv Foodie!";
					messageBody = generateHTMLBody1(emailType, userName, verificationCode);
					break;
					
				case PASSWORD_CHANGE:
					messageSubject = "Hi " + userName + ". Password Change Code from Festive Foodie!";
					messageBody = generateHTMLBody2(emailType, userName, verificationCode);
					break;
					
				case PAYMENT_COMPLETED:
					messageSubject = "Hi " + userName + ". Password Change Code from Festive Foodie!";
					messageBody = generateHTMLBody3(emailType, userName, OrderAmount, OrderDescription);
					break;
					
				case ORDER_ACCEPTED:
					messageSubject = "Hi " + userName + ". Password Change Code from Festive Foodie!";
					messageBody = generateHTMLBody4(emailType, userName, OrderAmount, OrderDescription);
					break;

				case ORDER_PREPARED:
					messageSubject = "Hi " + userName + ". Password Change Code from Festive Foodie!";
					messageBody = generateHTMLBody5(emailType, userName, OrderAmount, OrderDescription);
					break;
					
				case ORDER_DELIVERED:
					messageSubject = "Hi " + userName + ". Password Change Code from Festive Foodie!";
					messageBody = generateHTMLBody6(emailType, userName, OrderAmount, OrderDescription);
					
				case ORDER_CANCELLED:
					messageSubject = "Hi " + userName + ". Password Change Code from Festive Foodie!";
					messageBody = generateHTMLBody7(emailType, userName, OrderAmount, OrderDescription);
					break;
					
				default:
					return false;
			}
			
			email.setSubject(messageSubject);
			email.setMsg(messageBody);
			
			email.send();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public String generateHTMLBody1(EmailType et, String un, String vc)
	{
		return messageBody;
	}
	
	public String generateHTMLBody2(EmailType et, String un, String vc)
	{
		return messageBody;
	}
	
	public String generateHTMLBody3(EmailType et, String un, double oa, String od)
	{
		return messageBody;
	}
	
	public String generateHTMLBody4(EmailType et, String un, double oa, String od)
	{
		return messageBody;
	}
	
	public String generateHTMLBody5(EmailType et, String un, double oa, String od)
	{
		return messageBody;
	}
	
	public String generateHTMLBody6(EmailType et, String un, double oa, String od)
	{
		return messageBody;
	}
	
	public String generateHTMLBody7(EmailType et, String un, double oa, String od)
	{
		return messageBody;
	}
}
