package org.hov.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Users")
public class User 
{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int userId;
	
	@Column
	private int teamId;
	private String userEmail;
	private String userPassword;
	private String firstName;
	private String lastName;
	private String authority; //To be changed to Enumeration, Constants-> BUYER, SELLER, ADMIN.
	private String verificationCode;
	private boolean verified;
	private boolean blocked;
	private boolean suspended;

	public int getTeamId() 
	{
		return teamId;
	}

	public void setTeamId(int teamId) 
	{
		this.teamId = teamId;
	}
	
	public int getUserId() 
	{
		return userId;
	}
	
	public void setUserId(int userId) 
	{
		this.userId = userId;
	}
	
	public String getUserEmail() 
	{
		return userEmail;
	}
	
	public void setUserEmail(String userEmail) 
	{
		this.userEmail = userEmail;
	}
	
	public String getUserPassword() 
	{
		return userPassword;
	}
	
	public void setUserPassword(String userPassword) 
	{
		this.userPassword = userPassword;
	}
	
	public String getFirstName() 
	{
		return firstName;
	}
	
	public void setFirstName(String firstName) 
	{
		this.firstName = firstName;
	}
	
	public String getLastName() 
	{
		return lastName;
	}
	
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}
	
	public String getAuthority() 
	{
		return authority;
	}
	
	public void setAuthority(String authority) 
	{
		this.authority = authority;
	}
	
	public boolean isBlocked() 
	{
		return blocked;
	}
	
	public void setBlocked(boolean blocked) 
	{
		this.blocked = blocked;
	}

	public boolean isSuspended() 
	{
		return suspended;
	}

	public void setSuspended(boolean suspended) 
	{
		this.suspended = suspended;
	}

	public boolean isVerified() 
	{
		return verified;
	}

	public void setVerified(boolean verified) 
	{
		this.verified = verified;
	}

	public String getVerificationCode() 
	{
		return verificationCode;
	}

	public void setVerificationCode(String verificationCode) 
	{
		this.verificationCode = verificationCode;
	}
}
