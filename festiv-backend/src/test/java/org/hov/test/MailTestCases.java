package org.hov.test;

import org.hov.customlib.EmailOperations;

public class MailTestCases 
{
	public void testMail()
	{
		//send valid mail
		String vcode = "";
		EmailOperations eo = new EmailOperations();
		vcode = eo.sendEmail("Robin Dev", "exdev.robin@outlook.com", 1);
		System.out.println("The Verification code is: "+vcode);
	}

}
