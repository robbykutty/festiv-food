package org.hov.config;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

public class EmailConfig 
{
	static Email emailProperties;
	
	static 
	{
		initEmailProperties();
	}
	
	public static void initEmailProperties()
	{
		try
		{
			emailProperties = new SimpleEmail();
			emailProperties.setHostName("smtp.gmail.com.");
			emailProperties.setSmtpPort(465);
			emailProperties.setAuthenticator(new DefaultAuthenticator("pvt.robin@gmail.com", "ROD#KayTeaEm$55$"));
			emailProperties.setSSLOnConnect(true);
			emailProperties.setFrom("pvt.robin@gmail.com");
		}
		catch(Exception e)
		{
			emailProperties = null;
		}
	}
	
	public static Email getEmailProperties()
	{
		//subject, body, recipient email must be set to this object.
		return emailProperties;
	}
	
}
