package org.hov.dao;

import java.util.UUID;

import org.hov.model.Team;

public interface TeamDAO 
{
	public UUID addTeam(Team team);
	public boolean updateTeam(Team team);
	public Team getTeamById(int teamId);
	public boolean activateTeamById(int teamId);
	public boolean deactivateTeamById(int teamId);
}
