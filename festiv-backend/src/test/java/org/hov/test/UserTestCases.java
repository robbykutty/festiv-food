package org.hov.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.hov.config.AppConfig;
import org.hov.enumerators.Authority;
import org.hov.model.User;
import org.hov.service.UserService;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes=AppConfig.class)
public class UserTestCases 
{
	@Autowired
	UserService userService;
	
	User targetUser=null;
	
	/*  CREATION TEST CASES  */
	@Before public void getTargetUser() 
	{ 
		//targetUser = userService.getUserByEmail("sell@foodie.com"); 
	}
	
	@Test
	@Ignore
	public void addUserValid1()	
	{
		User user = new User();
		user.setFirstName("SellFirst");
		user.setLastName("SellLast");
		user.setUserEmail("test@foodie.com");
		user.setUserPassword("sell@123");
		user.setTeamId(0);
		user.setAuthority(Authority.ADMIN);
		user.setBlocked(true);

		assertEquals(true , userService.addUser(user));
	}
	
	/*
	 * @Test
	 * 
	 * @Ignore public void addUserInvalid1() //Invalid Record { User user = new
	 * User(); user.setFirstName("Tester123"); user.setLastName("123");
	 * user.setUserEmail("testing@foodieff.com"); user.setUserPassword("Test@123");
	 * user.setTeamId(0); user.setAuthority("BUYER"); user.setBlocked(false);
	 * 
	 * assertEquals(true , userService.addUser(user)); }
	 */
	
	/*  RETRIEVE TEST CASES  */
	@Test
	@Ignore
	public void displayAllUserListValid()
	{
		List<User> userlist = userService.getAllUsers();
		for(User u:userlist)
		{
			System.out.println("--------------------------");
			System.out.println(u.getUserId());
			System.out.println(u.getFirstName());
			System.out.println(u.getLastName());
			System.out.println(u.getUserEmail());
			System.out.println(u.getUserPassword());
			System.out.println(u.getAuthority());
			System.out.println(u.getVerificationCode());
			System.out.println(u.isVerified());
			System.out.println(u.isBlocked());
			System.out.println(u.isSuspended());
			System.out.println("");
		}
		assertNotNull(userlist);
	}

	@Test
	@Ignore
	public void displayUserbyIdValid1()	
	{
		System.out.println("TargetUserId:--------------> "+targetUser.getUserId());
		User u = userService.getUserById(targetUser.getUserId());

		if (u!=null)
		{
		System.out.println("--------------------------");
		System.out.println(u.getUserId());
		System.out.println(u.getFirstName());
		System.out.println(u.getLastName());
		System.out.println(u.getUserEmail());
		System.out.println(u.getUserPassword());
		System.out.println(u.getAuthority());
		System.out.println(u.getVerificationCode());
		System.out.println(u.isVerified());
		System.out.println(u.isBlocked());
		System.out.println(u.isSuspended());
		System.out.println("");
		}
		else
		{
			System.out.println("Object is null-------------->");
		}
		assertNotNull(u);
	}
	
	@Test
	@Ignore
	public void displayUserbyIdInvalid1()	//Expired
	{
		assertNull(userService.getUserById(targetUser.getUserId()));
	}
	
	@Test
	@Ignore
	public void displayUserbyEmailValid1()	
	{
		User u = userService.getUserByEmail("test@foodie.com");

		System.out.println("--------------------------");
		System.out.println(u.getUserId());
		System.out.println(u.getFirstName());
		System.out.println(u.getLastName());
		System.out.println(u.getUserEmail());
		System.out.println(u.getUserPassword());
		System.out.println(u.getAuthority());
		System.out.println(u.getVerificationCode());
		System.out.println(u.isVerified());
		System.out.println(u.isBlocked());
		System.out.println(u.isSuspended());
		System.out.println("");
		
		assertNotNull(u);
	}
	
	@Test
	@Ignore
	public void getUserbyEmailInvalid1()	
	{	
		assertNull(userService.getUserByEmail("x323535xxy3434y5454yzzz@foodie.com"));
	}

	/*  UPDATION TEST CASES  */
	@Test
	@Ignore
	public void updateUserValid1()	// 
	{
		targetUser.setFirstName("Updated Name");
		assertEquals(true, userService.updateUser(targetUser));
	}
	
	/*  SUB-UPDATION TEST CASES  */
	@Test
	@Ignore
	public void blockUserValid()	
	{
		assertEquals(true, userService.blockUserById(targetUser.getUserId()));
	}
	
	@Test
	@Ignore
	public void unblockUserValid()
	{
		assertEquals(true, userService.unblockUserById(targetUser.getUserId()));
	}
	
	@Test
	@Ignore
	public void suspendUserValid()	
	{
		assertEquals(true, userService.suspendUserById(targetUser.getUserId()));
	}
}
