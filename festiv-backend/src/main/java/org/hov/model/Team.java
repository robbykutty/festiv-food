package org.hov.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table (name="Teams")
public class Team 
{
	private int teamId;
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
