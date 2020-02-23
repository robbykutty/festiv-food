package org.hov.test;

import java.util.List;

import org.hov.dao.UserDAO;
import org.hov.daoimpl.UserDAOImpl;
import org.hov.model.User;
import org.hov.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserTest 
{
	
	public static void addUser()
	{
		UserDAOImpl udao1= new UserDAOImpl();
		User user = new User();
		
		user.setFirstName("First Name 1");
		user.setLastName("Last Name 1");
		user.setUserEmail("user123@foodie.com");
		user.setUserPassword("user@123");
		user.setTeamId(1);
		user.setAuthority("BUYER");
		user.setVerified(false);
		user.setBlocked(false);
		user.setSuspended(false);

		System.out.println("Add =>" + udao1.addUser(user));
	}
	
	public static void updateUser()
	{
		UserDAOImpl udao1= new UserDAOImpl();
		User user = udao1.getUserById(11);
		
		user.setFirstName("First Name Changed-Autowired");

		System.out.println("Updated =>" +udao1.updateUser(user));
	}
	
	public static void displayAllUser()
	{
		UserDAOImpl udao= new UserDAOImpl();
		List<User> userlist = udao.getAllUsers();
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
	}
	
	public static void displayUserbyId()
	{
		UserDAOImpl udao= new UserDAOImpl();
		User u = udao.getUserById(5);

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
	
	public static void displayUserbyEmail()
	{
		UserDAOImpl udao= new UserDAOImpl();
		User u = udao.getUserByEmail("user123@foodie.com");

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
	
	public static void blockUser()
	{
		UserDAOImpl udao= new UserDAOImpl();
		//System.out.println("Blocked: " + udao.blockUserById(5));
		//System.out.println("Expired: " + udao.suspendUserById(5));
		System.out.println("Unblocked: " + udao.unblockUserById(5));
	}
	
	public static void main(String[] args)
	{
		//addUser();
		//updateUser();
		//displayUserbyId();
		//displayUserbyEmail();
		//displayAllUser();
		//blockUser();
	}
}
