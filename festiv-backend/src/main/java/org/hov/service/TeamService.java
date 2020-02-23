package org.hov.service;

import org.hov.model.Team;

public interface TeamService 
{
	public int addTeam(Team team);
	public boolean updateTeam(Team team);
	public Team getTeamById(int teamId);
	public boolean activateTeamById(int teamId);
	public boolean deactivateTeamById(int teamId);
}
