package org.hov.test;

import static org.junit.Assert.assertEquals;

import org.hov.config.AppConfig;
import org.hov.service.EmailService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes = AppConfig.class)
public class MailTestCases 
{
	@Autowired
	EmailService emailSevice;
	
	@Test
	//@Ignore
	public void testSpringMail()
	{
		assertEquals(true, emailSevice.sendSimpleMail("exdev.robin@gmail.com", 
													  "Hi Test Subject", 
													  "Email Test Email Body"));
	}
}
