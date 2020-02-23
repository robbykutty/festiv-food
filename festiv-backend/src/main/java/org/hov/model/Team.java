package org.hov.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Teams")
public class Team 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int teamId;
	
	@Column
	private String teamName;
	private String teamDescription;
	private boolean active;
	
	public int getTeamId() 
	{
		return teamId;
	}
	public void setTeamId(int teamId) 
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
