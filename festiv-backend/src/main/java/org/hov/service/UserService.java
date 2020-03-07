package org.hov.service;

import java.util.List;
import java.util.UUID;

import org.hov.model.User;

public interface UserService
{
	public boolean addUser(User user);
	public boolean updateUser(User user);
	public List<User> getAllUsers();
	public User getUserById(UUID userId);
	public User getUserByEmail(String userEmail);
	public boolean blockUserById(UUID userId);
	public boolean unblockUserById(UUID userId);
	public boolean suspendUserById(UUID userId);
}
