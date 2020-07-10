package org.hov.generators;

import org.hov.enumerators.EmailType;
import org.hov.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;

public class EmailGenerator 
{
	@Autowired
	EmailService emailService;

	public String subject;
	public String body;
	
	public static String subject1;
	public static String subject2;
	public static String subject3;
	public static String subject4;
	public static String subject5;
	public static String subject6;
	public static String subject7;
	public static String subject8;

	public static String body1;
	public static String body2;
	public static String body3;
	public static String body4;
	public static String body5;
	public static String body6;
	public static String body7;
	public static String body8;
	
	static
	{
		/* EMAIL SUBJECT TEMPLATE*/
		subject1 = "Hi $XNAMEX$,Festive Foodie Email Verification.";
		subject2 = "Hi $XNAMEX$,Festive Foodie Password Change Code.";
		subject3 = "Hi $XNAMEX$,Festive Foodie Payment Recieved For Order# $XORDERIDX$";
		subject4 = "Hi $XNAMEX$,Festive Foodie Order# $XORDERIDX$ Accepted";
		subject5 = "Hi $XNAMEX$,Festive Foodie Order# $XORDERIDX$ Cancelled";
		subject6 = "Hi $XNAMEX$,Festive Foodie Order# $XORDERIDX$ Prepared.";
		subject7 = "Hi $XNAMEX$,Festive Foodie Order# $XORDERIDX$ Delivered.";
		subject8 = "Hi $XNAMEX$,Festive Foodie Order# $XORDERIDX$ Refunded.";
		
		/* EMAIL BODY TEMPLATE */
		body1 = "";
		body2 = "";
		body3 = "";
		body4 = "";
		body5 = "";
		body6 = "";
		body7 = "";
		body8 = "";
	}
	
	public boolean build(EmailType etyp)
	{
		subject = "";
		body = "";
		switch(etyp)
		{
			case VERIFICATION:
				subject = subject1;
				body = body1;
				break;
			case PASSWORD_CHANGE:
				subject = subject2;
				body = body2;
				break;
			case PAYMENT_COMPLETED:
				subject = subject3;
				body = body3;
				break;
			case ORDER_ACCEPTED:
				subject = subject4;
				body = body4;
				break;
			case ORDER_CANCELLED:
				subject = subject5;
				body = body5;
				break;
			case ORDER_PREPARED:
				subject = subject6;
				body = body6;
				break;
			case ORDER_DELIVERED:
				subject = subject7;
				body = body7;
				break;
			case ORDER_REFUNDED:
				subject = subject8;
				body = body8;
				break;
			default:
				return false;
		}
		return true;
	}
	
	public boolean send(EmailType emailType, 
					    String    name, 
					    String    email,
					    Double    orderAmount,
					    String    orderId,
					    String    orderDescription,
					    String    verificationCode)
	{
		try
		{
			if (build(emailType) && subject !="" && body !="")
			{
				emailService.sendSimpleMail(email, subject, body);
				return true;
			}
			else
			{
				return false;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return true;
		}
	}
}