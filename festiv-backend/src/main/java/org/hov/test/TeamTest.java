package org.hov.test;

import org.hov.daoimpl.TeamDAOImpl;
import org.hov.model.Team;

public class TeamTest 
{
	public static void addTeam()
	{
		TeamDAOImpl tdi = new TeamDAOImpl();
		Team team = new Team();
		
		team.setTeamName("Team Name 1");
		team.setTeamDescription("Team Description 1");
		team.setActive(true);
		
		System.out.println("Added: " + tdi.addTeam(team));
	}
	
	public static void updateTeam()
	{
		TeamDAOImpl tdi = new TeamDAOImpl();
		Team team = tdi.getTeamById(2);
		
		team.setTeamDescription("Updated Team 1 Description");

		System.out.println("Updated: " + tdi.updateTeam(team));
	}
	
	public static void displayTeam()
	{
		TeamDAOImpl tdi = new TeamDAOImpl();
		Team tm = tdi.getTeamById(2);
		
		System.out.println("------------------------------------");
		System.out.println("Team Id: " + tm.getTeamId());
		System.out.println("Team Name: " + tm.getTeamName());
		System.out.println("Team Description: " + tm.getTeamDescription());
		System.out.println("Team Active: " + tm.isActive());
	}
	
	public static void activateTeam()
	{
		TeamDAOImpl tdi = new TeamDAOImpl();
		tdi.activateTeamById(2);
		//tdi.deactivateTeamById(2);
	}
	
	public static void main(String[] args)
	{
		//addTeam();
		updateTeam();
		//activateTeam();
		displayTeam();
	}
}
