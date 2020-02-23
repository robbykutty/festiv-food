package org.hov.dao;

import java.util.List;

import org.hov.model.User;

public interface UserDAO
{
	public boolean addUser(User user);
	public boolean updateUser(User user);
	public List<User> getAllUsers();
	public User getUserById(int userId);
	public User getUserByEmail(String userEmail);
	public boolean blockUserById(int userId);
	public boolean unblockUserById(int userId);
	public boolean suspendUserById(int userId);
}
