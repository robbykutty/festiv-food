package org.hov.service;

import java.util.UUID;

import org.hov.model.Team;

public interface TeamService 
{
	public UUID addTeam(Team team);
	public boolean updateTeam(Team team);
	public Team getTeamById(int teamId);
	public boolean activateTeamById(int teamId);
	public boolean deactivateTeamById(int teamId);
}
