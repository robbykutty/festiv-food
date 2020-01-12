package org.hov.dao;

import java.util.List;

import org.hov.model.User;

public interface UserDAO
{
	public int addUser(User user);
	public List<User> displayAllUsers();
	public User getUserById(int userId);
	public User getUserByEmail(String userEmail);
	public boolean updateUserById(User user);
	public boolean blockUserById(int userId);
	public boolean unblockUserById(int userId);
}
