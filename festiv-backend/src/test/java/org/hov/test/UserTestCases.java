package org.hov.test;

import org.hov.model.User;
import org.junit.Ignore;
import org.junit.Test;

public class UserTestCases 
{
	@Test
	@Ignore
	public void addValidUser1()
	{
		//valid record
		User user = new User();
		
		user.setFirstName("Tester");
		user.setLastName("123");
		user.setUserEmail("testing@foodieff.com");
		user.setUserPassword("Test@123");
		user.setTeamId(0);
		user.setAuthority("BUYER");
		user.setBlocked(false);
	}
	
}
