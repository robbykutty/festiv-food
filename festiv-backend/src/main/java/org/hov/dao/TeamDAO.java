package org.hov.dao;

import org.hov.model.Team;

public interface TeamDAO 
{
	public int addTeam(Team team);
	public Team getTeamById(int teamId);
	public boolean blockTeamById(int teamId);
	public boolean unblockTeamById(int teamId);
}
