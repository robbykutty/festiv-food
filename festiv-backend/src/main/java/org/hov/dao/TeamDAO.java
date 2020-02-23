package org.hov.dao;

import org.hov.model.Team;

public interface TeamDAO 
{
	public int addTeam(Team team);
	public boolean updateTeam(Team team);
	public Team getTeamById(int teamId);
	public boolean activateTeamById(int teamId);
	public boolean deactivateTeamById(int teamId);
}
