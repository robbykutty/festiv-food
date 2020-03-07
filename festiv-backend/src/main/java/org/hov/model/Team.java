package org.hov.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table (name="Teams")
public class Team 
{
	@Id
	@GeneratedValue
	private UUID teamId;

	@Column(unique = true)
	@NotBlank(message = "Stall Name is Mandatory")
	@Length(min = 5, message = "Cannot be less than 5 characters")
	@Length(max = 25, message = "Cannot be more than 25 characters")
	private String teamName;
	
	@Column
	@NotBlank(message = "Stall Description is Mandatory")
	@Length(min = 10, message = "Cannot be less than 10 characters")
	@Length(max = 70, message = "Cannot be more than 70 characters")
	private String teamDescription;
	
	@Column
	@NotNull
	private boolean active;
	
	
	public UUID getTeamId() 
	{
		return teamId;
	}

	public void setTeamId(UUID teamId) 
	{
		this.teamId = teamId;
	}

	public String getTeamName() 
	{
		return teamName;
	}
	
	public void setTeamName(String teamName) 
	{
		this.teamName = teamName;
	}
	
	public String getTeamDescription() 
	{
		return teamDescription;
	}
	
	public void setTeamDescription(String teamDescription) 
	{
		this.teamDescription = teamDescription;
	}
	
	public boolean isActive() 
	{
		return active;
	}
	
	public void setActive(boolean active) 
	{
		this.active = active;
	}
}
