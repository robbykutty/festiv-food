package org.hov.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import org.hov.enumerators.Authority;

@Entity
@Table (name="Users")
public class User 
{

	@Id
	@GeneratedValue
	@Type(type = "uuid-char")
	private UUID userId;
	
	@Column(updatable = false)
	@NotBlank
	private int teamId;
	
	@Column(unique = true)
	@NotBlank
	@Pattern(regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)"	  //As per RFC 5322 Standards
			        + "*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f"
			        + "]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0"
			        + "-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]"
			        + "|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-"
			        + "9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x2"
			        + "1-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])", 
			  message="Email not valid")
	private String userEmail;
	
	@Column
	@NotBlank
	@Length(min = 2, max = 16, message = "Must be atleast 6-12 characters long")
	//@Pattern(regexp="", message="Did not meet password requirement")
	private String userPassword;
	
	@Column
	@URL(protocol = "https")
	private String userPictureURL;
	
	@Column
	@NotBlank(message = "First Name is Mandatory")
	@Length(min = 2, message = "Cannot be less than 2 characters")
	@Length(max = 16, message = "Cannot be more than 16 characters")
	private String firstName;

	@Column
	@NotBlank(message = "Last Name is Mandatory")
	@Length(min = 2, message = "Cannot be less than 2 characters")
	@Length(max = 16, message = "Cannot be more than 16 characters")
	private String lastName;

	@NotBlank
	@Column
	@Enumerated(EnumType.STRING)
	private Authority authority;
	
	@NotBlank
	@Column(length = 6)
	private String verificationCode;
	
	@Column
	@NotNull
	private boolean verified;

	@Column
	@NotNull
	private boolean blocked;

	@Column
	@NotNull
	private boolean suspended;

	public int getTeamId() 
	{
		return teamId;
	}

	public void setTeamId(int teamId) 
	{
		this.teamId = teamId;
	}
	
	public UUID getUserId() 
	{
		return userId;
	}

	public void setUserId(UUID userId) 
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
	
	public Authority getAuthority() 
	{
		return authority;
	}
	
	public void setAuthority(Authority authority) 
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

	public String getUserPictureURL() 
	{
		return userPictureURL;
	}

	public void setUserPictureURL(String userPicture) 
	{
		this.userPictureURL = userPicture;
	}
}
